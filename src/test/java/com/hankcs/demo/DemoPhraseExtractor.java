/*
 * <summary></summary>
 * <author>He Han</author>
 * <email>hankcs.cn@gmail.com</email>
 * <create-date>2014/12/9 13:55</create-date>
 *
 * <copyright file="DemoPhraseExtractor.java" company="上海林原信息科技有限公司">
 * Copyright (c) 2003-2014, 上海林原信息科技有限公司. All Right Reserved, http://www.linrunsoft.com/
 * This source is subject to the LinrunSpace License. Please contact 上海林原信息科技有限公司 to get more information.
 * </copyright>
 */
package com.hankcs.demo;

import com.hankcs.hanlp.HanLP;

import java.util.List;

/**
 * 短语提取
 * @author hankcs
 */
public class DemoPhraseExtractor
{
    public static void main(String[] args)
    {
        String text = "1.和家人互动玩球\n" +
            "家人把玩具球扔过来让宝宝接住，或者让宝宝投掷玩具球，不仅能增加亲子互动，还能锻炼宝宝的敏捷性和肢体协调性。\n" +
            "2.跑步\n" +
            "跑步对成人来说没有什么难的，但是对孩子来说，每个方面都是要学习的技巧。例如，帮助孩子学会用鼻子呼吸，年龄越小越难做到这一点，故一般是先教会幼儿口鼻呼吸，呼吸时嘴不张大，然后过渡到完全用鼻呼吸。\n" +
            "根据孩子的体质强弱与气候变化，安排跑步的强度与持续时间，从几分钟开始，逐步加长时间。由于幼儿期各方面功能还不完善，初始阶段一般不超过20分钟为好。夏季尽可能安排在清晨，冬季可适当晚一点。\n" +
            "3.建立孩子的勇气\n" +
            "你会发现很多喜欢运动的小孩子都是能说会道，而且有自己的想法，你也会发现现在很多孩子都去体适能中心上课，透过门窗你会发现有些小孩子绝对让你惊讶，那么小但一系列的运动却可以做到那么的极致，而且也不会觉得说是一种逼迫，一大群小朋友互相角逐，建立了“革命友谊”。\n" +
            "4.孩子可以游泳\n" +
            "婴儿游泳是专门为婴幼儿设计的一套活动方式，宝宝们在婴儿游泳池里游泳和孕妇羊水中生活类似，而且婴儿游泳能够让宝宝尽情的舒展身体，全身的肌肉、骨骼和关节都在活动，调节了宝宝的血液循环和新陈代谢能力，提高宝宝的心肺能力。同时游泳可以促进宝宝的胃肠道激素分泌，提高消化能力和食欲，有助于宝宝身心放松舒适，提高了宝宝的睡眠质量。\n" +
            "5.孩子可以跳绳\n" +
            "跳绳也是一项很适合孩子的全身运动，跳绳能增强孩子节奏感,跳绳可一促进小孩子长高,总之适当的给小孩子运动对小孩子身心健康有一定的帮助,增强孩子的体质。\n" +
            " ";
        List<String> phraseList = HanLP.extractPhrase(text, 5);
        System.out.println(phraseList);
    }
}
