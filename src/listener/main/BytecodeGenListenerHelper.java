package listener.main;

import generated.MiniCParser;
import generated.MiniCParser.*;

import java.util.ArrayList;

public class BytecodeGenListenerHelper {
    // <boolean functions>

    static boolean isFunDecl(MiniCParser.ProgramContext ctx, int i) {
        return ctx.getChild(i).getChild(0) instanceof MiniCParser.Fun_declContext;
    }

    // type_spec IDENT '[' ']'
    static boolean isArrayParamDecl(ParamContext param) {
        return param.getChildCount() == 4;
    }

    // global vars
    static Object initVal(Var_declContext ctx, SymbolTable.Type type) {
        String value = ctx.LITERAL().getText();
        switch (type) {
            case INT:
                return Integer.parseInt(value);
            case DOUBLE:
                return Double.parseDouble(value);
            case CHAR:
                return value.charAt(0);
            case FLOAT:
                return Float.parseFloat(value);
            default:
                return value;
        }
    }

    static String getType(String type){
        switch (type) {
            case "int":
                return "I";
            case "float":
                return "F";
            case "double":
                return "D";
            case "char":
                return "C";
        }
        return null;
    }

    static String getArrayType(String type){
        switch (type) {
            case "int":
                return "[I";
            case "float":
                return "[F";
            case "double":
                return "[D";
            case "char":
                return "[C";
        }
        return null;
    }

    static SymbolTable.Type getArrayTypeEnum(String type){
        switch (type) {
            case "int":
                return SymbolTable.Type.INTARRAY;
            case "float":
                return SymbolTable.Type.FLOAT_ARRAY;
            case "double":
                return SymbolTable.Type.DOUBLE_ARRAY;
            case "char":
                return SymbolTable.Type.CHARARRAY;
        }
        return null;
    }

    // var_decl	: type_spec IDENT '=' LITERAL ';
    static boolean isDeclWithInit(Var_declContext ctx) {
        return ctx.getChildCount() == 5;
    }


    // var_decl	: type사_spec IDENT '[' LITERAL ']' ';'
    static boolean isArrayDecl(Var_declContext ctx) {
        return ctx.getChildCount() == 6;
    }

    // <local vars>
    // local_decl	: type_spec IDENT '[' LITERAL ']' ';'
    static Object initVal(Local_declContext ctx, SymbolTable.Type type) {
        String value = ctx.LITERAL().getText();
        switch (type) {
            case INT:
                return Integer.parseInt(value);
            case DOUBLE:
                return Double.parseDouble(value);
            case CHAR:
                return value.charAt(0);
            case FLOAT:
                return Float.parseFloat(value);
            default:
                return value;
        }
    }

    static boolean isArrayDecl(Local_declContext ctx) {
        return ctx.getChildCount() == 6;
    }

    static boolean isDeclWithInit(Local_declContext ctx) {
        return ctx.getChildCount() == 5;
    }

    static boolean isDeclWithArray(Local_declContext ctx) {
        return ctx.getChildCount() == 6;
    }

    static boolean isDeclWithArray(MiniCParser.ExprContext ctx) {
        return ctx.getChildCount() == 6;
    }


    static boolean isVoidF(Fun_declContext ctx) {
        // 함수의 리턴 값 형식이 void인지 검
        if (ctx.type_spec().getText().equals("void"))
            return true;
        return false;
    }

    static boolean isIntReturn(MiniCParser.Return_stmtContext ctx) {
        return ctx.getChildCount() == 3; // int type 확인 코드 추가하기
    }

    static boolean isVoidReturn(MiniCParser.Return_stmtContext ctx) {
        return ctx.getChildCount() == 2;
    }

    // <information extraction>

    static String getStackSize(String stmt) {
        int stackSize=0;
        String[] sp=stmt.split("\t|\n");
        for(int i=0; i<sp.length; i++){
            if(sp[i].contains("ldc2_w"))
                stackSize++;
            if(sp[i].contains("load")|sp[i].contains("const")|sp[i].contains("dup")
                    |sp[i].contains("invoke")|sp[i].contains("jsr")|sp[i].contains("ldc")|sp[i].contains("push")){
                stackSize++;
            }
        }
        return stackSize+"";
    }

    static String getLocalVarSize(Fun_declContext ctx) {
        int localVarSize=0;
        if(getFunName(ctx).equals("main")){
            localVarSize++;
        }
        int params=ctx.params().getChildCount();
        if(params>0)
            params=ctx.params().getChildCount()/2+1;
        localVarSize+=params;
        ArrayList compoundStmt= (ArrayList) ctx.compound_stmt().children;
        for(int i=0; i<compoundStmt.size(); i++){
            if(compoundStmt.get(i) instanceof Local_declContext){
                localVarSize++;
                if(((Local_declContext) compoundStmt.get(i)).type_spec().getText().equals("double"))
                    localVarSize++;
            }

        }
        return localVarSize+"";
    }

    static String getTypeText(Type_specContext typespec) {
        // Potion
        return typespec.getChild(0).getText();
    }

    // params
    static String getParamName(ParamContext param) {
        // <Fill in>
        System.out.println("??");
        return "??";
    }

    static String getParamTypesText(ParamsContext params) {
        String typeText = "";
        for (int i = 0; i < params.param().size(); i++) {
            MiniCParser.Type_specContext typespec = (MiniCParser.Type_specContext) params.param(i).getChild(0);
            typeText += getTypeText(typespec) + "//"; // SymbolTable class의 putFunSpecStr에서 사용하기 용이하게 하기 위해 추
        }
        return typeText;
    }

    static String getLocalVarName(Local_declContext local_decl) {
        // var_decl	:  type_spec IDENT ';'
        return local_decl.IDENT().getText();
    }

    static String getFunName(Fun_declContext ctx) {
        // fun_decl	: type_spec IDENT '(' params ')' compound_stmt ;
        return ctx.IDENT().getText();
    }

    static String getFunName(ExprContext ctx) {
        // fun_decl	: type_spec IDENT '(' params ')' compound_stmt ;
        return ctx.IDENT().getText();
    }

    // bug fix, else없는 if문 child갯수가 5임
    static boolean noElse(If_stmtContext ctx) {
        return ctx.getChildCount() <= 5;
    }

    static String getFunProlog() {
        // 클래스 선언부분, 생성자부분 미리 생성해둠
        String prolog = ".class public Test\n" +
                ".super java/lang/Object\n" +
                ".method public <init>()V\n" +
                "\t.limit stack 1\n" +
                "\t.limit locals 1\n" +
                "\taload_0\n" +
                "\tinvokespecial java/lang/Object/<init>()V\n";

        return prolog;
    }

    static String getCurrentClassName() {
        return "Test";
    }
}
