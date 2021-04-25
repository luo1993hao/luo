package org.luo.practice.refactor;


/**
 * 摘抄于clean-code
 * 最终版
 * warn:下面注释并不规范，只是为了标明我具体的步骤
 * 注释规范请阅读clean-code 第4章
 */
public class FinalComparisonCompactor {
    private static final String ELLIPSIS = "...";
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";
    /**
     * STEP1：变量改名 去掉无意义的f
     */
    private int contextLength;
    private String expected;
    private String actual;
    /**
     * STEP7:增加2个字段
     */
    private String compactExpected;
    private String compactActual;
    /**
     * STEP9:修改变量名 prefixIndex->prefixIndexIndex，suffixIndex->suffixIndexIndex
     * 原因：细看逻辑，其实这2个字段表示的是索引
     */
    private int prefixIndex;
    private int suffixIndex;

    public FinalComparisonCompactor(int ContextLength, String expected, String actual) {
        this.contextLength = ContextLength;
        this.expected = expected;
        this.actual = actual;
    }

    /**
     * STEP5:修改方法名
     * 原因：如果canBeCompact为false，实际上就不会压缩字符串
     * 直接用compact命名，隐藏了错误检查的副作用（函数章节中-方法不应该有副作用），所以重命名为formatCompactedComparison
     *
     * @param message
     * @return
     */
    public String formatCompactedComparison(String message) {
        /**
         *
         */
        if (canBeCompacted()) {
            /**
             * STEP6:2个字符串在这里进行压缩，所以应该抽离一个compactExceptedAndActual方法
             * （函数章节中-一个函数应该只做一个方法）。如果不拆分这里format方法就做了2个事情：1.压缩2个字符串 2.格式化字符串
             */
            compactExpectedAndActual();
            return message + compactExpected + compactActual;

        } else {
            //            return Assert.format(message,expected,actual);未找到该依赖，使用以下代替返回值，不影响主要逻辑
            return message + expected + actual;
        }


    }

    /**
     * STEP2:封装条件判断，从方法命名让意图更明显 expected == null || actual == null || areStringEqual()=>方法
     *
     * @return
     */
    private boolean shouldNotCompact() {
        return expected == null || actual == null || areStringEqual();
    }

    /**
     * STEP4:肯定式易读性大于否定式，将shouldNotCompact改一下
     *
     * @return
     */
    private boolean canBeCompacted() {
        return !shouldNotCompact();
    }

    private void compactExpectedAndActual() {
        findComPrefixAndSuffix();
        /**
         * STEP3：修改重名变量名
         */
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }

    private String compactString(String source) {
        String result = DELTA_START + source.substring(prefixIndex, source.length() - suffixIndex + 1) + DELTA_END;
        if (prefixIndex > 0) {
            result = computeCommonprefixIndex() + result;
        }
        if (suffixIndex > 0) {
            result = result + computeCommonsuffixIndex();
        }
        return result;
    }

    /**
     * STEP8:
     * 修改下面2个方法
     * 原因：仔细看下面2个方法，其实隐藏着一个时序耦合。suffix依赖于prefix。现在是属于人为维护这个顺利关系。
     * 避免下一个人误操作，我们应该隐藏时序性（函数章节-方法应该隐藏时序性）
     */
    private void findCommonprefix() {
        prefixIndex = 0;
        int end = Math.min(expected.length(), actual.length());
        for (; prefixIndex < end; prefixIndex++) {
            if (expected.charAt(prefixIndex) != actual.charAt(prefixIndex)) {
                break;
            }

        }
    }

    /**
     * 将findCommonsuffix 修改为findComPrefixAndSuffix（）
     * 在其中调用findCommonPrefix。隐藏时序性
     *
     * @return
     */
    private void findComPrefixAndSuffix() {
        findCommonprefix();
        int expectedsuffixIndex = expected.length() - 1;
        int actualsuffixIndex = actual.length() - 1;
        for (; actualsuffixIndex >= prefixIndex && expectedsuffixIndex >= prefixIndex; actualsuffixIndex--, expectedsuffixIndex--) {
            if (expected.charAt(expectedsuffixIndex) != actual.indexOf(actualsuffixIndex)) {
                break;
            }
        }
        suffixIndex = expected.length() - expectedsuffixIndex;
    }

    private String computeCommonprefixIndex() {
        return (prefixIndex > contextLength ? ELLIPSIS : "") + expected.substring(Math.max(0, prefixIndex - contextLength), prefixIndex);
    }

    private String computeCommonsuffixIndex() {
        int end = Math.min(expected.length() - suffixIndex + 1 + contextLength, expected.length());
        return expected.substring(expected.length() - suffixIndex + 1, end) + (expected.length() - suffixIndex + 1 < expected.length() - contextLength ? ELLIPSIS : "");
    }

    private boolean areStringEqual() {
        return expected.equals(actual);
    }

}

