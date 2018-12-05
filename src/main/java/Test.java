import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.model.perceptron.PerceptronLexicalAnalyzer;
import com.hankcs.hanlp.seg.Segment;

import java.io.IOException;
import java.util.*;

/**
 * @Auther: zhongyuxinxi-02
 * @Date: 2018-12-03 11:14
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

//        Segment segment = HanLP.newSegment().enableNameRecognize(true);
        List<String> strings = HanLP.extractSummary("生命在于运动 一个懒惰的人和一个每天都坚持运动的人是有差别的。运动能改变我们的体形、身体状况。", 4);
        CoNLLSentence sentence = HanLP.parseDependency(strings.get(0));
        System.out.println(sentence);
        //存放关系的集合
        List<Map<String, List<CoNLLWord>>> rootList = new ArrayList<Map<String, List<CoNLLWord>>>();
        Map<String, List<CoNLLWord>> map = new HashMap<String, List<CoNLLWord>>();
        // 可以方便地遍历它
        for (CoNLLWord word : sentence) {
            //依存关系id
            int id = word.ID;
//            循环每个实体与其他实体的关系
            for (CoNLLWord temp : sentence) {
                //存放相同关系的集合
                ArrayList<CoNLLWord> words = new ArrayList<CoNLLWord>();
                //判断word和temp是否存在关系
                if (temp.HEAD.ID == id) {
                    //如果map中存在已经存在关系，那么加入对应的list，没有就新加入
                    if (map.containsKey(temp.DEPREL)) {
                        List<CoNLLWord> coNLLWords = map.get(temp.DEPREL);
                        coNLLWords.add(temp);
                    } else {
                        words.add(temp);
                        map.put(temp.DEPREL, words);
                    }
                }
            }
            System.out.println(map);
//            词语依存字典  System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
        }
        rootList.add(map);
        CoNLLWord[] wordArray = sentence.getWordArray();
        //句法依存分析
        ArrayList<CoNLLWord> coNLLWords = new ArrayList<CoNLLWord>();
        for (int i = 0; i < wordArray.length; i++) {
            CoNLLWord coNLLWord = wordArray[i];
            coNLLWords.add(coNLLWord);
        }
        Set<String> extract = extract(coNLLWords, rootList);
        System.out.println(extract);
    }

    /**
     * @param parser 句法依存分析
     * @param dict   词语依存字典
     * @return 三元组列表
     */
    private static Set<String> extract(List<CoNLLWord> parser, List<Map<String, List<CoNLLWord>>> dict) {
        Set<String> result = new HashSet<String>();
        //存放核心关系
        String rootrelation = "";
        for (CoNLLWord coNLLWord : parser) {
            if (coNLLWord.DEPREL.equals("核心关系")) {
                rootrelation = coNLLWord.LEMMA;

            }
        }
            //获取所有关系
            Map<String, List<CoNLLWord>> dic = dict.get(0);
            if (dic.containsKey("主谓关系") && dic.containsKey("动宾关系")) {
                //获取主语
                CoNLLWord entity1 = dic.get("主谓关系").get(0);

                    CoNLLWord entity2 = dic.get("动宾关系").get(0);
                    result.add(entity1.LEMMA + "," + rootrelation + "," + entity2.LEMMA);

            } else if (dic.containsKey("主谓关系") && dic.containsKey("介宾关系")) {
                //获取主语
                CoNLLWord entity1 = dic.get("主谓关系").get(0);

                CoNLLWord entity2 = dic.get("介宾关系").get(0);
                result.add(entity1.LEMMA + "," + rootrelation + "," + entity2.LEMMA);

            }


//        Set<String> result = new HashSet<String>();
        // 主谓宾关系：刘小绪生于四川
//        if (dic.containsKey("主谓关系") && dic.containsKey("动宾关系")) {
//            CoNLLWord entity1 = dic.get("主谓关系").get(0);
//            // 排除：刘小绪和李华是朋友
//            // entity1.ID-1 即主语在依存字典中的索引
//            if (dict.get(entity1.ID - 1).containsKey("并列关系")) {
//                String relation = dic.get("动宾关系").get(0).LEMMA;
//                CoNLLWord entity2 = dict.get(entity1.ID - 1).get("并列关系").get(0);
//                result.add(entity1.LEMMA + "," + relation + "," + entity2.LEMMA);
//            } else {
//                CoNLLWord entity2 = dic.get("动宾关系").get(0);
//                String relation = word.LEMMA;
//                result.add(entity1.LEMMA + "," + relation + "," + entity2.LEMMA);
//            }
//        }

        // 动补结构：刘小绪洗干净了衣服
//        if (dic.containsKey("动补结构") && dic.containsKey("主谓关系") && dic.containsKey("动宾关系")) {
//            CoNLLWord entity1 = dic.get("主谓关系").get(0);
//            CoNLLWord complement = dic.get("动补结构").get(0);
//            CoNLLWord entity2 = dic.get("动宾关系").get(0);
//            if (dic.containsKey("右附加关系")) {
//                CoNLLWord subjoin = dic.get("右附加关系").get(0);
//                String relation = word.LEMMA + complement.LEMMA + subjoin.LEMMA;
//                result.add(entity1.LEMMA + "," + relation + "," + entity2.LEMMA);
//            } else {
//                String relation = word.LEMMA + complement.LEMMA;
//                result.add(entity1.LEMMA + "," + relation + "," + entity2.LEMMA);
//            }
//        }
        return result;
    }
}