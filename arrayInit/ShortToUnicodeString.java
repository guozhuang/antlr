//将初始化数据进行unicode转码
public class ShortToUnicodeString extends ArrayInitBaseListener {


    //初始化结构为{}。所以enterInit为{
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    //初始化结构为{}。所以ExitInit为}
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    //对匹配内容进行转换
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }
}