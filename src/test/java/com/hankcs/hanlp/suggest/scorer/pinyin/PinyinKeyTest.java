package com.hankcs.hanlp.suggest.scorer.pinyin;

import com.hankcs.hanlp.algorithm.LongestCommonSubstring;
import junit.framework.TestCase;

public class PinyinKeyTest extends TestCase
{
    public void testConstruct() throws Exception
    {
        PinyinKey pinyinKeyA = new PinyinKey();
        PinyinKey pinyinKeyB = new PinyinKey();
//        System.out.println(pinyinKeyA);
//        System.out.println(pinyinKeyB);
        assertEquals(1, LongestCommonSubstring.compute(pinyinKeyA.getFirstCharArray(), pinyinKeyB.getFirstCharArray()));
    }
}