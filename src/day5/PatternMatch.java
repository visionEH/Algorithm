package day5;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class PatternMatch {


    public static void main(String[] args) {
        char [] str = "a".toCharArray();
        char[] pattern = "a.*".toCharArray();
        System.out.println(new PatternMatch().match(str,pattern));
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    /**
     * 错误
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
          int strLength = str.length;
          int patLength = pattern.length;
          int tag = 0; //表示*的作用域
          int i = 0 ;
          int start = 0;
          if (strLength == 0 && patLength != 0){
            while (start < patLength){
                if (start + 1 < patLength && pattern[start+1] == '*'){
                    start += 2;
                } else {
                    return false;
                }
            }
            return true;
          }
          for (; (i < strLength) && (start < patLength); i++){
              if (tag == 1){
                  if (str[i] == pattern[start-1]){
                      continue;
                  } else {
                      start ++;
                      tag = 0;
                      if (start >= patLength){
                          break;
                      }
                  }
              }
              if(pattern[start] == '.' || pattern[start] == str[i]){
                      start++;
                      tag = 0;
                      continue;
              } else if(pattern[start] == '*'){
                      tag = 1;
              } else if(start+1 < patLength && pattern[start+1] == '*'){
                      start += 2;
                      i--;
              } else{
                  break;
              }
          }
          while (start < patLength){
            if (start + 1 < patLength && pattern[start+1] == '*'){
                start += 2;
            } else {
                break;
            }
          }
          while (start < patLength){
            if (pattern[start] == '*')
               start++;
            else
                break;
          }
          return i >= strLength && start >= patLength;
    }
}
