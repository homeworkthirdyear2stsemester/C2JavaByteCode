package listener.main;

import generated.MiniCParser;
import generated.MiniCParser.*;

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
    static int initVal(Var_declContext ctx) {
        return Integer.parseInt(ctx.LITERAL().getText());
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
    static int initVal(Local_declContext ctx) {
        return Integer.parseInt(ctx.LITERAL().getText());
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
    static String getStackSize(Fun_declContext ctx) {
        return "32";
    }

    static String getLocalVarSize(Fun_declContext ctx) {
        return "32";
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
                "\tinvokespecial java/lang/Object/<init>()V\n" +
                "\treturn\n" +
                ".end method\n\n";
        return prolog;
    }

    static String getCurrentClassName() {
        return "Test";
    }
}
