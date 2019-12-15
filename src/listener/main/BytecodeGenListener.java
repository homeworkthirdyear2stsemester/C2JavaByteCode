package listener.main;

import generated.MiniCBaseListener;
import generated.MiniCParser;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.StmtContext;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

import static listener.main.BytecodeGenListenerHelper.*;
import static listener.main.SymbolTable.Type;

public class BytecodeGenListener extends MiniCBaseListener implements ParseTreeListener {
    ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();
    SymbolTable symbolTable = new SymbolTable();
    char className = 'T';
    String prolog = ".class public Test\n" +
            ".super java/lang/Object\n" ;
    int tab = 0;
    int label = 0;

    // program	: decl+

    @Override
    public void enterFun_decl(MiniCParser.Fun_declContext ctx) {
        symbolTable.initFunDecl();
        String fname = getFunName(ctx);
        ParamsContext params;
        increaseTabs();

        if (fname.equals("main")) {
            symbolTable.putLocalVar("args", Type.INTARRAY);
        } else {
            symbolTable.putFunSpecStr(ctx);
            params = (MiniCParser.ParamsContext) ctx.getChild(3);
            symbolTable.putParams(params);
        }
    }

    @Override
    public void enterExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        super.enterExpr_stmt(ctx);
    }

    // var_decl	: type_spec IDENT ';' | type_spec IDENT '=' LITERAL ';'|type_spec IDENT '[' LITERAL ']' ';'
    @Override
    public void enterVar_decl(MiniCParser.Var_declContext ctx) {
        String varName = ctx.IDENT().getText();

        if (isArrayDecl(ctx)) {
            String typeStr = ctx.getChild(0).getText();
            symbolTable.putGlobalVar(varName, getArrayTypeEnum(typeStr));
            prolog += ".field  public static " + varName + " " + getArrayType(typeStr) + "\n";
        } else{
            String typeStr = ctx.getChild(0).getText();
            prolog += ".field  public static " + varName + " " + getType(typeStr) + "\n";
            if (isDeclWithInit(ctx)) {
                Type type = symbolTable.getTypeFromString(ctx.getChild(0));
                symbolTable.putGlobalVarWithInitVal(varName, type, initVal(ctx, type));
            } else { // simple decl
                symbolTable.putGlobalVar(varName, ctx);
            }
        }
    }


    @Override
    public void enterLocal_decl(MiniCParser.Local_declContext ctx) {
        String typeName = ctx.getChild(0).getText();
        if (isArrayDecl(ctx)) {
            if (typeName.equals("char"))
                symbolTable.putLocalVar(getLocalVarName(ctx), Type.CHARARRAY);
            else if (typeName.equals("int"))
                symbolTable.putLocalVar(getLocalVarName(ctx), Type.INTARRAY);
        } else if (isDeclWithInit(ctx)) {
            if (typeName.equals("char"))
                symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.CHAR, initVal(ctx, Type.CHAR));
            else if (typeName.equals("int"))
                symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.INT, initVal(ctx, Type.INT));
            else if(typeName.equals("double"))
                symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.DOUBLE, initVal(ctx, Type.DOUBLE));
            else if(typeName.equals("float"))
                symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.FLOAT, initVal(ctx, Type.FLOAT));
        } else { // simple decl
            if (typeName.equals("char"))
                symbolTable.putLocalVar(getLocalVarName(ctx), Type.CHAR);
            else if (typeName.equals("int"))
                symbolTable.putLocalVar(getLocalVarName(ctx), Type.INT);
            else if(typeName.equals("double"))
                symbolTable.putLocalVar(getLocalVarName(ctx), Type.DOUBLE);
            else if(typeName.equals("float"))
                symbolTable.putLocalVar(getLocalVarName(ctx), Type.FLOAT);
        }
    }


    @Override
    public void exitProgram(MiniCParser.ProgramContext ctx) {
        prolog += ".method public <init>()V\n" +
                "   .limit stack 3\n" +
                "   .limit locals 1\n"+
                "   aload_0\n" +
                "  invokespecial java/lang/Object/<init>()V\n"+
                "   return\n" +
                ".end method\n\n";
        String staticProlog = ".method static public <clinit>()V\n" +
                "   .limit stack 2\n";
        String staticEpilog = "    return\n" +
                ".end method\n";
        String fun_decl = "", var_decl = "";

        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (isFunDecl(ctx, i))
                fun_decl += newTexts.get(ctx.decl(i));
            else
                var_decl += newTexts.get(ctx.decl(i));
        }
        String staticLogic = staticProlog + var_decl + staticEpilog;
        newTexts.put(ctx, prolog + staticLogic + fun_decl);
        System.out.println(newTexts.get(ctx));
    }


    // decl	: var_decl | fun_decl
    @Override
    public void exitDecl(MiniCParser.DeclContext ctx) {
        String decl = "";
        if (ctx.getChildCount() == 1) {
            if (ctx.var_decl() != null)                //var_decl
                decl += newTexts.get(ctx.var_decl());
            else                                    //fun_decl
                decl += newTexts.get(ctx.fun_decl());
        }
        newTexts.put(ctx, decl);
    }

    // stmt	: expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt
    @Override
    public void exitStmt(MiniCParser.StmtContext ctx) {
        String stmt = "";
        if (ctx.getChildCount() > 0) {
            if (ctx.expr_stmt() != null)                // expr_stmt
                stmt += newTexts.get(ctx.expr_stmt());
            else if (ctx.compound_stmt() != null)    // compound_stmt
                stmt += newTexts.get(ctx.compound_stmt());
            else if (ctx.if_stmt() != null)            // if_stmt
                stmt += newTexts.get(ctx.if_stmt());
            else if (ctx.while_stmt() != null)        // while_stmt
                stmt += newTexts.get(ctx.while_stmt());
            else if (ctx.return_stmt() != null)        // return_stmt
                stmt += newTexts.get(ctx.return_stmt());
            else if (ctx.for_stmt() != null) {
                stmt += newTexts.get(ctx.for_stmt());
            }
        }
        newTexts.put(ctx, stmt);
    }

    // expr_stmt	: expr ';'
    @Override
    public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        String stmt = "";
        if (ctx.getChildCount() == 2) {
            stmt += newTexts.get(ctx.expr());    // expr
        }
        newTexts.put(ctx, stmt);
    }


    // while_stmt	: WHILE '(' expr ')' stmt
    @Override
    public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
        // Potion
        String whileStmt = "";

        // 조건 부분
        String condExpr = newTexts.get(ctx.expr());
        // 괄호 안 내용
        String stmt = newTexts.get(ctx.stmt());

        // while에서 쓸 라벨 두가지 생성 및 저장
        String lloop = symbolTable.newLabel();
        String lend = symbolTable.newLabel();

        // 탭 생성
        String tabs = makeTabs();

        // 조건을 체크하여 그 조건의 결과값으로 분기하여 stmt부분 반복시킬지, 빠져나올지 결정
        whileStmt += tabs + lloop + ":" + "\n"
                + condExpr
                + tabs + "ifeq " + lend + "\n"
                + stmt
                + tabs + "goto " + lloop + "\n"
                + tabs + lend + ":" + "\n";

        // while부분 변환한 내용 저장
        newTexts.put(ctx, whileStmt);
    }

    // fun_decl	: type_spec IDENT '(' params ')' compound_stmt ;
    // .method public static add(II)I
    @Override
    public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
        // Potion
        StringBuilder func = new StringBuilder();
        String ident = ctx.IDENT().getText();
        String compoundStmt = newTexts.get(ctx.compound_stmt());
        // enterfun_decl에서 탭을 하나 추가하여 해당 stmt에서 모두 증가된 탭을 적용하였는데
        // funcHeader부분에서 .method public~~ 부분은 탭이 하나 빠져있으므로 잠시 감소하였다가 헤더에서 다시 증가시킨다.
        decreaseTabs();
        func.append(funcHeader(ctx, ident));
        func.append(compoundStmt);
        // void 리턴 함수면 여기서 넣어준다.
        if (isVoidF(ctx))
            func.append(makeTabs() + "return\n");
        decreaseTabs();
        // 마무리
        func.append(makeTabs() + ".end method\n\n");
        symbolTable.exitFunc();
        newTexts.put(ctx, func.toString());
    }

    private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) {
        StringBuilder header = new StringBuilder();
        // 이부분때문에 이 함수 호출전에 잠시 decreaseTabs를 했었음
        header.append(makeTabs() + ".method public static " + symbolTable.getFunSpecStr(fname) + "\n");
        // 원상복구
        increaseTabs();
        header.append(makeTabs() + ".limit stack " + getStackSize(newTexts.get(ctx.compound_stmt())) + "\n");
        header.append(makeTabs() + ".limit locals " + getLocalVarSize(ctx) + "\n");
        return header.toString();
    }

    @Override
    public void exitVar_decl(MiniCParser.Var_declContext ctx) {
        String varName = ctx.IDENT().getText();
        String varDecl = "";
        if(isArrayDecl(ctx)){
            varDecl +="     ldc " + ctx.LITERAL().getText() + "\n"
                    + "    newarray " + ctx.getChild(0).getText() + "\n"
                    + "    putstatic " + symbolTable.getVarId(varName);
        }else if (isDeclWithInit(ctx)) {
            varDecl += "     aload 0\n"
                    +"     ldc " + ctx.LITERAL().getText() + "\n"
                    + "    putstatic " + symbolTable.getVarId(varName);
            // v. initialization => Later! skip now..:
        }
        newTexts.put(ctx, varDecl);
    }


    @Override
    public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
        String varDecl = "";
        if (isDeclWithInit(ctx)) {
            String store="istore_";
            String loadConstant="ldc ";
            if(symbolTable.getVarType(ctx.IDENT().getText()).name().equals("DOUBLE")){
                store="dstore_";
                loadConstant="ldc2_w ";
            }
            else if(symbolTable.getVarType(ctx.IDENT().getText()).name().equals("INT")|symbolTable.getVarType(ctx.IDENT().getText()).name().equals("CHAR"))
                store="istore_";
            else if(symbolTable.getVarType(ctx.IDENT().getText()).name().equals("FLOAT"))
                store="fstore_";
            String vId = symbolTable.getVarId(ctx);
            varDecl += makeTabs() + loadConstant + ctx.LITERAL().getText() + "\n"
                    + makeTabs() + store + vId + "\n";
        } else if (isDeclWithArray(ctx)) {
            String vId = symbolTable.getVarId(ctx);
            String arraySize = ctx.getChild(3).getText();
            String varType = ctx.getChild(0).getText();
            varDecl += makeTabs() + "bipush " + arraySize + '\n'
                    + makeTabs() + "newarray " + varType + '\n'
                    + makeTabs() + "astore " + vId + '\n';
        }
        newTexts.put(ctx, varDecl);
    }


    // compound_stmt	: '{' local_decl* stmt* '}'
    @Override
    public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
        String compoundStmt;
        StringBuilder localDecl = new StringBuilder();
        StringBuilder stmt = new StringBuilder();
        List<Local_declContext> localDeclList = ctx.local_decl();
        // 존재하는 local_decl 모두 불러와서 추가
        for (int i = 0; i < localDeclList.size(); i++) {
            localDecl.append(newTexts.get(localDeclList.get(i)));
        }
        List<StmtContext> stmtList = ctx.stmt();
        // 존재하는 stmt 모두 불러와서 추가
        for (int i = 0; i < stmtList.size(); i++) {
            stmt.append(newTexts.get(stmtList.get(i)));
        }
        compoundStmt = localDecl.toString() + stmt.toString();
        newTexts.put(ctx, compoundStmt);
    }

    // if_stmt	: IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
    @Override
    public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
        String stmt = "";
        String condExpr = newTexts.get(ctx.expr());
        String thenStmt = newTexts.get(ctx.stmt(0));

        String lend = symbolTable.newLabel();
        String lelse = symbolTable.newLabel();

        String tabs = makeTabs();

        if (noElse(ctx)) {
            stmt += tabs + condExpr + "\n"
                    + tabs + "ifeq " + lend + "\n"
                    + thenStmt + "\n"
                    + tabs + lend + ":" + "\n";
        } else {
            String elseStmt = newTexts.get(ctx.stmt(1));
            stmt += tabs + condExpr + "\n"
                    + tabs + "ifeq " + lelse + "\n"
                    + tabs + thenStmt + "\n"
                    + tabs + "goto " + lend + "\n"
                    + tabs + lelse + ": \n"
                    + tabs + elseStmt + "\n"
                    + tabs + lend + ":" + "\n";
        }
        newTexts.put(ctx, stmt);
    }


    // return_stmt	: RETURN ';' | RETURN expr ';'
    @Override
    public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        // Potion
        String stmt = "";
        // void return의 경우 exitfunc_decl에서 처리해줬으므로 int 형만 처리해주면됨
        if (isIntReturn(ctx)) {
            // 리턴할 값 로드
            stmt = newTexts.get(ctx.expr());
            // ireturn
            stmt += makeTabs() + "i" + ctx.RETURN().getText() + "\n";
        }

        newTexts.put(ctx, stmt);
    }

    @Override
    public void exitFor_stmt(MiniCParser.For_stmtContext ctx) {
        String forStmt = "";
        MiniCParser.For_conditionContext forConditionContext = ctx.for_condition();
        // 초기값 설정
        String assignment = "";
        // 조건 부분
        String condExpr = "";
        // 괄호 안 내용
        String lastExpr = "";
        int countSemiClone = 0;
        for (int index = 0; index < forConditionContext.getChildCount(); index++) {
            if (!forConditionContext.getChild(index).getText().equals(";")) {
                if (countSemiClone == 0) {
                    assignment = newTexts.get(forConditionContext.getChild(index));
                } else if (countSemiClone == 1) {
                    condExpr = newTexts.get(forConditionContext.getChild(index));
                } else {
                    lastExpr = newTexts.get(forConditionContext.getChild(index));
                }
            } else {
                countSemiClone++;
            }
        }

        String stmt = newTexts.get(ctx.compound_stmt());


        // while에서 쓸 라벨 두가지 생성 및 저장
        String lloop = symbolTable.newLabel();
        String lend = symbolTable.newLabel();

        // 탭 생성
        String tabs = makeTabs();

        // 조건을 체크하여 그 조건의 결과값으로 분기하여 stmt부분 반복시킬지, 빠져나올지 결정
        forStmt += assignment
                + tabs + lloop + ":" + "\n"
                + condExpr
                + tabs + "ifeq " + lend + "\n"
                + stmt
                + lastExpr
                + tabs + "goto " + lloop + "\n"
                + tabs + lend + ":" + "\n";

        // while부분 변환한 내용 저장
        newTexts.put(ctx, forStmt);
    }


    @Override
    public void exitExpr(MiniCParser.ExprContext ctx) {
        String expr = "";
        if (ctx.getChildCount() <= 0) {
            newTexts.put(ctx, "");
            return;
        } else if (ctx.getChildCount() == 1) { // IDENT | LITERAL
            if (ctx.IDENT() != null) {
                String idName = ctx.IDENT().getText();
                if (symbolTable.getVarType(idName) == Type.INT || symbolTable.getVarType(idName) == Type.CHAR) {
                    // 글로벌 변수일 경우
                    String inGlobal = symbolTable.getVarId(idName);
                    if(inGlobal != null && inGlobal.charAt(0) == className){
                        expr += makeTabs() + "aload 0 \n"
                                + makeTabs() + "getstatic " + symbolTable.getVarId(idName);
                    }else{
                        expr += makeTabs() + "iload_" + symbolTable.getVarId(idName) + " \n";
                    }
                } else if(symbolTable.getVarType(idName)==Type.FLOAT){
                    // todo 맞는지 확인부탁
                    String inGlobal = symbolTable.getVarId(idName);
                    if(inGlobal != null && inGlobal.charAt(0) == className){
                        expr += makeTabs() + "aload 0 \n"
                                + makeTabs() + "getstatic " + symbolTable.getVarId(idName);
                    }else{
                        expr += makeTabs() + "fload_" + symbolTable.getVarId(idName) + " \n";
                    }
                }  else if(symbolTable.getVarType(idName)==Type.DOUBLE){
                    // todo 맞는지 확인부탁
                    String inGlobal = symbolTable.getVarId(idName);
                    if(inGlobal != null && inGlobal.charAt(0) == className){
                        expr += makeTabs() + "aload 0 \n"
                                + makeTabs() + "getstatic " + symbolTable.getVarId(idName);
                    }else{
                        expr += makeTabs() + "dload_" + symbolTable.getVarId(idName) + " \n";
                    }
                }
                //else	// Type int array => Later! skip now..
                //	expr += "           lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
            } else if (ctx.LITERAL() != null) {
                String literalStr = ctx.LITERAL().getText();
                expr += makeTabs() + "ldc " + literalStr + " \n";
            } else if (ctx.CHAR_SET() != null) {
                String charStr = ctx.CHAR_SET().getText();
                int char2int = charStr.charAt(1);
                expr += makeTabs() + "bipush " + char2int + " \n";
            } else if (ctx.FLOAT_IDENT() != null) {
                // float
                String doubleStr = ctx.FLOAT_IDENT().getText();
                expr += makeTabs() + "ldc " + doubleStr + " \n";
                // todo double


            }
        } else if (ctx.getChildCount() == 2) { // UnaryOperation
//			expr = handleUnaryExpr(ctx, newTexts.get(ctx) + expr);
            // bug fix
            expr = handleUnaryExpr(ctx, expr);
        } else if (ctx.getChildCount() == 3) {
            if (ctx.getChild(0).getText().equals("(")) {        // '(' expr ')'
                expr = newTexts.get(ctx.expr(0));
            } else if (ctx.getChild(1).getText().equals("=")) {    // IDENT '=' expr
                // 글로벌 변수일 경우
                String inGlobal = symbolTable.getVarId(ctx.IDENT().getText());
                if(inGlobal != null && inGlobal.charAt(0) == className){
                    expr = makeTabs() + "aload 0 \n"
                            + newTexts.get(ctx.expr(0))
                            + makeTabs() + "putstatic " + symbolTable.getVarId(ctx.IDENT().getText());
                }else{
                    String store="";
                    if(symbolTable.getVarType(ctx.IDENT().getText()).name().equals("DOUBLE"))
                        store="dstore_";
                    else if(symbolTable.getVarType(ctx.IDENT().getText()).name().equals("INT")|symbolTable.getVarType(ctx.IDENT().getText()).name().equals("CHAR"))
                        store="istore_";
                    else if(symbolTable.getVarType(ctx.IDENT().getText()).name().equals("FLOAT"))
                        store="fstore_";

                    if(!store.equals(""))
                        expr = newTexts.get(ctx.expr(0))
                            + makeTabs() + store + symbolTable.getVarId(ctx.IDENT().getText()) + "\n";
                }
            } else { // binary operation
                // bug fix
                expr = handleBinExpr(ctx, expr);
            }
        }
        // IDENT '(' args ')' |  IDENT '[' expr ']'
        else if (ctx.getChildCount() == 4) {
            if (ctx.args() != null) {        // function calls
                expr = handleFunCall(ctx, expr);
            } else { // expr
                // Arrays: TODO
                // a[n] 과 같은것 로드
                String varName = ctx.getChild(0).getText();
                String index = ctx.expr(0).getText();

                String tabs = makeTabs();
                String load = "";

                String loadVariable ="";
                // 글로벌인지 확인한다.
                String inGlobal = symbolTable.getVarId(varName);
                if(inGlobal != null && inGlobal.charAt(0) == className){
                    loadVariable = tabs + "getstatic " + symbolTable.getVarId(varName);
                }else{
                    String varId = symbolTable.getVarId(varName);
                    loadVariable = tabs + "aload " + varId + '\n';
                }

                Type varType = symbolTable.getVarType(varName);
                if (varType == Type.INTARRAY) {
                    load = "iaload";
                } else if (varType == Type.CHARARRAY) {
                    load = "caload";
                } else if(varType == Type.DOUBLE_ARRAY){
                    load = "daload";
                } else if(varType == Type.FLOAT_ARRAY){
                    load = "faload";
                }
                expr += loadVariable
                        + tabs + "bipush " + index + '\n'
                        + tabs + load + "\n";
            }
        } else if (isDeclWithArray(ctx)) {
            // a[0] = 10 과 같은것 처리
            String varName = ctx.getChild(0).getText();
            if (symbolTable.getVarType(varName) == Type.INTARRAY) {
                String index = ctx.expr(0).getText();
                String value = ctx.expr(1).getText();
                String tabs = makeTabs();

                String loadVariable ="";
                // 글로벌인지 확인한다.

                String inGlobal = symbolTable.getVarId(varName);
                if(inGlobal != null && inGlobal.charAt(0) == className){
                    loadVariable = tabs + "getstatic " + symbolTable.getVarId(varName);
                }else{
                    String varId = symbolTable.getVarId(varName);
                    loadVariable = tabs + "aload " + varId + '\n';
                }

                expr += loadVariable
                        + tabs + "bipush " + index + '\n'
                        + tabs + "bipush " + value + '\n'
                        + tabs + "iastore \n";
            } else if (symbolTable.getVarType(varName) == Type.CHARARRAY) {
                String index = ctx.expr(0).getText();
                int value = (int) ctx.expr(1).getText().charAt(1);
                String tabs = makeTabs();

                String loadVariable ="";
                // 글로벌인지 확인한다.
                String inGlobal = symbolTable.getVarId(varName);
                if(inGlobal != null && inGlobal.charAt(0) == className){
                    loadVariable = tabs + "getstatic " + symbolTable.getVarId(varName);
                }else{
                    String varId = symbolTable.getVarId(varName);
                    loadVariable = tabs + "aload " + varId + '\n';
                }

                expr += loadVariable
                        + tabs + "bipush " + index + '\n'
                        + tabs + "bipush " + value + '\n'
                        + tabs + "iastore \n";
            }
        }
        // IDENT '[' expr ']' '=' expr
        else { // Arrays: TODO			*/
        }
        newTexts.put(ctx, expr);
    }

    private String handleUnaryExpr(MiniCParser.ExprContext ctx, String expr) {
        String l1 = symbolTable.newLabel();
        String l2 = symbolTable.newLabel();
        String lend = symbolTable.newLabel();
        String tabs = makeTabs();
        String id = ctx.expr(0).getText();
        expr += newTexts.get(ctx.expr(0));
        String inGlobal = "";
        switch (ctx.getChild(0).getText()) {
            // String id2 = ctx.expr(1).getText();
            ////				expr += makeTabs()+"iload_" + symbolTable.getVarId(id1) + "\n"+
            case "-":
                expr += tabs + "ineg \n";
                break;
            case "--":
                expr += tabs + "ldc 1" + "\n"
                        + tabs + "isub" + "\n";
                // 글로벌인지 확인
                inGlobal = symbolTable.getVarId(id);
                if(inGlobal != null && inGlobal.charAt(0) == className){
                    expr += tabs + "putstatic " + symbolTable.getVarId(id) + "\n"; // bug fix, 연산 값 다시 저장 필요함
                }else{
                    expr += tabs + "istore_" + symbolTable.getVarId(id) + "\n"; // bug fix, 연산 값 다시 저장 필요함
                }
                break;
            case "++":
                expr += tabs + "ldc 1" + "\n"
                        + tabs + "iadd" + "\n";
                // 글로벌인지 확인
                inGlobal = symbolTable.getVarId(id);
                if(inGlobal != null && inGlobal.charAt(0) == className){
                    expr += tabs + "putstatic " + symbolTable.getVarId(id) + "\n"; // bug fix, 연산 값 다시 저장 필요함
                }else{
                    expr += tabs + "istore_" + symbolTable.getVarId(id) + "\n"; // bug fix, 연산 값 다시 저장 필요함
                }
                break;
            case "!":
                expr += tabs + "ifeq " + l2 + "\n"
                        + tabs + l1 + ": " + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ": \n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
        }
        return expr;
    }


    private String handleBinExpr(MiniCParser.ExprContext ctx, String expr) {
        String l2 = symbolTable.newLabel();
        String lend = symbolTable.newLabel();
        String tabs = makeTabs();
        expr += newTexts.get(ctx.expr(0));
        expr += newTexts.get(ctx.expr(1));

        switch (ctx.getChild(1).getText()) {
            case "*":
                expr += tabs + "imul \n";
                break;
            case "/":
                expr += tabs + "idiv \n";
                break;
            case "%":
                expr += tabs + "irem \n";
                break;
            case "+":        // expr(0) expr(1) iadd
                expr += tabs + "iadd \n";
                break;
            case "-":
                expr += tabs + "isub \n";
                break;
            case "==":
                expr += tabs + "isub " + "\n"
                        + tabs + "ifeq" + l2 + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ": " + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case "!=":
                expr += tabs + "isub " + "\n"
                        + tabs + "ifne " + l2 + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ":" + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case "<=":
                // 두 값을 빼서 오른쪽에 있던 값을 왼쪽으로 이항하는 동작을 함. 그 뒤 결과를 ifle로 확인하여
                // true/false에 맞게 분기
                expr += tabs + "isub " + "\n"
                        + tabs + "ifle " + l2 + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ":" + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case "<":
                // 두 값을 빼서 오른쪽에 있던 값을 왼쪽으로 이항하는 동작을 함. 그 뒤 결과를 iflt로 확인하여
                // true/false에 맞게 분기
                expr += tabs + "isub " + "\n"
                        + tabs + "iflt " + l2 + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ":" + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case ">=":
                // 두 값을 빼서 오른쪽에 있던 값을 왼쪽으로 이항하는 동작을 함. 그 뒤 결과를 ifge로 확인하여
                // true/false에 맞게 분기
                expr += tabs + "isub " + "\n"
                        + tabs + "ifge " + l2 + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ":" + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case ">":
                // 두 값을 빼서 오른쪽에 있던 값을 왼쪽으로 이항하는 동작을 함. 그 뒤 결과를 ifgt로 확인하여
                // true/false에 맞게 분기
                expr += tabs + "isub " + "\n"
                        + tabs + "ifgt " + l2 + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + "goto " + lend + "\n"
                        + tabs + l2 + ":" + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case "and":
                expr += tabs + "ifne " + lend + "\n"
                        + tabs + "pop" + "\n"
                        + tabs + "ldc 0" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
            case "or":
                // 첫번째 인자를 확인하였을 때 false이면 두번째 인자에 따라 값이 결정되므로 바로 end로 보내고
                // True이면 두번째 값이 어떤건지 상관없이 무조건 True이므로 두번째 값 pop하고 그자리에 1 넣어서 끝낸다.
                expr += tabs + "ifeq " + lend + "\n"
                        + tabs + "pop" + "\n"
                        + tabs + "ldc 1" + "\n"
                        + tabs + lend + ": " + "\n";
                break;
        }
        return expr;
    }

    private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
        String fname = getFunName(ctx);
        if (fname.equals("_print")) { // System.out.println
            String arg = ctx.args().expr(0).getText();
            if (symbolTable.getVarType(arg) == Type.CHAR) {
                arg = "(C)";
            } else if (symbolTable.getVarType(arg) == Type.DOUBLE) {
                arg = "(D)";
            } else if (symbolTable.getVarType(arg) == Type.FLOAT) {
                arg = "(F)";
            } else {
                arg = "(I)";
            }
            expr = makeTabs() + "getstatic java/lang/System/out Ljava/io/PrintStream;" + "\n"
                    + newTexts.get(ctx.args())
                    + makeTabs() + "invokevirtual " + symbolTable.getFunSpecStr("_print") + arg + "V" + "\n";
        } else {
            expr = newTexts.get(ctx.args())
                    + makeTabs() + "invokestatic " + getCurrentClassName() + "/" + symbolTable.getFunSpecStr(fname) + "\n";
        }
        return expr;
    }

    // args	: expr (',' expr)* | ;
    @Override
    public void exitArgs(MiniCParser.ArgsContext ctx) {
        String argsStr = "";
        for (int i = 0; i < ctx.expr().size(); i++) {
            argsStr += newTexts.get(ctx.expr(i));
        }
        newTexts.put(ctx, argsStr);
    }

    // tab 값에 맞게 탭 생성하여 리턴
    private String makeTabs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    // 탭 하나 증가
    private void increaseTabs() {
        tab++;
    }

    // 탭 하나 증가
    private void decreaseTabs() {
        tab--;
    }
}
