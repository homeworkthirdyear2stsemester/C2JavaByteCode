package listener.main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import generated.MiniCParser;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;
import listener.main.SymbolTable.Type;
import static listener.main.BytecodeGenListenerHelper.*;

public class SymbolTable {
	enum Type {
		INT, INTARRAY, VOID, ERROR, CHARARRAY
	}
	
	static public class VarInfo {
		Type type; 
		int id;
		int initVal;
		
		public VarInfo(Type type,  int id, int initVal) {
			this.type = type;
			this.id = id;
			this.initVal = initVal;
		}
		public VarInfo(Type type,  int id) {
			this.type = type;
			this.id = id;
			this.initVal = 0;
		}
	}
	
	static public class FInfo {
		public String sigStr;
	}
	
	private Map<String, VarInfo> _lsymtable = new HashMap<>();	// local v.
	private Map<String, VarInfo> _gsymtable = new HashMap<>();	// global v.
	private Map<String, FInfo> _fsymtable = new HashMap<>();	// function 
	
		
	private int _globalVarID = 0;
	private int _localVarID = 0;
	private int _labelID = 0;
	private int _tempVarID = 0;

	SymbolTable(){
		_lsymtable.clear();
		initFunDecl();
		initFunTable();
	}

	public void exitFunc(){
		_lsymtable.clear();
		initFunDecl();
		initFunTable();
	}
	
	void initFunDecl(){		// at each func decl
		_localVarID = 0;
		_labelID = 0;
		_tempVarID = 32;		
	}
	
	void putLocalVar(String varname, Type type){
		// 초기값 없는 지역 변수
		VarInfo vInfo=new VarInfo(type,_localVarID++);
		_lsymtable.put(varname, vInfo);
	}
	
	void putGlobalVar(String varname, Type type){
		// 초기값 없는 전역 변수
		VarInfo vInfo=new VarInfo(type,_globalVarID++);
		_gsymtable.put(varname, vInfo);
	}
	
	void putLocalVarWithInitVal(String varname, Type type, int initVar){
		// 초기값 있는 지역 변수
		VarInfo vInfo=new VarInfo(type,_localVarID++,initVar);
		_lsymtable.put(varname, vInfo);
	}
	void putGlobalVarWithInitVal(String varname, Type type, int initVar){
		// 초기값 있 전역 변수는
		VarInfo vInfo=new VarInfo(type,_globalVarID++,initVar);
		_gsymtable.put(varname, vInfo);
	}
	
	void putParams(MiniCParser.ParamsContext params) {
		// 파라미터를 모두 순회하며 타입정보 검사 후 파라미터는 지역변수이므로 putLocalVar함수를 사용하여 넣어줌
		for(int i = 0; i < params.param().size(); i++) {
			Type type;
			String typeSpec=params.param(i).type_spec().getText();
			if(typeSpec.equals("int"))
				type=Type.INT;
			else if(typeSpec.equals("void"))
				continue;
			else if(isArrayParamDecl(params.param(i)))
				type=Type.INTARRAY;
			else
				type=Type.ERROR;
			putLocalVar(params.param(i).IDENT().getText(),type);
		}
	}
	
	private void initFunTable() {
		FInfo printlninfo = new FInfo();
		printlninfo.sigStr = "java/io/PrintStream/println(I)V";
		
		FInfo maininfo = new FInfo();
		maininfo.sigStr = "main([Ljava/lang/String;)V";
		_fsymtable.put("_print", printlninfo);
		_fsymtable.put("main", maininfo);
	}
	
	public String getFunSpecStr(String fname) {
		// _fsymtable에서 값을 가져와서 해당하는 String가져와서 반환
		FInfo fun = _fsymtable.get(fname);
		if (fun != null) {
			return fun.sigStr;
		}
		return null;
	}

	public String getFunSpecStr(Fun_declContext ctx) {
		// getFunSpecStr(String fname)에서 fname의 인자는 함수의 이름이 들어가야 하므로
		// IDENT.getText로 함수 이름을 가져와서 구해서 리턴
		String fname=ctx.IDENT().getText();
		return getFunSpecStr(fname);
	}
	
	public String putFunSpecStr(Fun_declContext ctx) {
		// add(II)I 의 형식으로 만들어야함, 함수 이름(파라미터자료형)반환형
		String fname = getFunName(ctx);
		StringBuilder argtype = new StringBuilder();
		String rtype = "";
		String res = "";
		String[] argTypeSplit=getParamTypesText(ctx.params()).split("//");
		// getParamTypesText함수를 이용하여 모두 가져와 알맞게 I와 V로 변환
		for(int i=0; i<argTypeSplit.length; i++){
			switch (argTypeSplit[i]){
				case "int":
					argtype.append("I");
					break;
				case "void":
					argtype.append("V");
					break;
			}
		}
		// 반환형은 하나이므로 반복문 없이 switch로 연산함
		switch (ctx.type_spec().getText()){
			case "int":
				rtype = "I";
				break;
			case "void":
				rtype = "V";
				break;
		}
		// 합쳐서 함수 심볼테이블에 저장
		res =  fname + "(" + argtype + ")" + rtype;

		FInfo finfo = new FInfo();
		finfo.sigStr = res;
		_fsymtable.put(fname, finfo);
		
		return res;
	}
	
	String getVarId(String name){
		// 지역변수인지 전역변수인지 확인하여 알맞게 반환
		VarInfo lvar = _lsymtable.get(name);
		if (lvar != null) {
			return lvar.id+"";
		}
		VarInfo gvar = _gsymtable.get(name);
		if (gvar != null) {
			return gvar.id+"";
		}
		return null;
	}
	
	Type getVarType(String name){
		VarInfo lvar = _lsymtable.get(name);
		if (lvar != null) {
			return lvar.type;
		}
		VarInfo gvar = _gsymtable.get(name);
		if (gvar != null) {
			return gvar.type;
		}
		return Type.ERROR;	
	}

	String newLabel() {
		return "label" + _labelID++;
	}
	
	String newTempVar() {
		String id = "";
		return id + _tempVarID--;
	}

	// global
	public String getVarId(Var_declContext ctx) {
		// getVarId(String name)의 name은 변수의 이름이 되야하는데
		// ctx를 인자로 받았으므로 IDENT를 리턴하여 진행
		return getVarId(ctx.IDENT().getText());
	}

	// local
	public String getVarId(Local_declContext ctx) {
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}
}