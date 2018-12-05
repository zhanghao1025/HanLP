/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/12/7 21:13</create-date>
 *
 * <copyright file="DemoAll.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014, 上海林原信息科技有限公司. All Right Reserved, http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.demo;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import com.hankcs.hanlp.model.perceptron.Config;
import com.hankcs.hanlp.model.perceptron.PerceptronPOSTagger;
import com.hankcs.hanlp.model.perceptron.PerceptronTrainer;
import com.hankcs.hanlp.seg.Segment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 第一个Demo，惊鸿一瞥
 *
 * @author hankcs
 */
public class DemoAtFirstSight
{
    public static void main(String[] args)
    {

        PerceptronPOSTagger tagger = null;
        try {
            tagger = new PerceptronPOSTagger(Config.POS_MODEL_FILE);
        System.out.println(Arrays.toString(tagger.tag("膳食营养 交响乐团 谭利华 在 布达拉宫 广场 演出".split(" "))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
