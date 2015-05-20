import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<String> dict = new HashSet<>();
        int totalLen = 0;
        for (int i = 0; i < words.length; i++) {
            dict.add(words[i]);
            totalLen += words[i].length();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Set<String> explored = new HashSet<>();
            if (wordBreak(s.substring(i, i + totalLen), dict)) {
                result.add(i);
            }
        }
        return result;
    }

    // public boolean wordBreak(String s, Set<String> dict, Set<String> explored) {
    //     if (s.length() == 0) {
    //         return true;
    //     }
    //     for (int i = 1; i <= s.length(); i++) {
    //         String w = s.substring(0, i);
    //         System.out.println(w);
    //         if (dict.contains(w) && !explored.contains(w)) {
    //             explored.add(w);
    //             if (wordBreak(s.substring(i), dict, explored)) {
    //                 return true;
    //             }
    //             explored.remove(w);
    //         }
    //     }
    //     return false;
    // }

    public boolean wordBreak(String s, Set<String> dict) {
        Map<Integer, List<Set<String>>> map = new HashMap<>();
        int len = s.length();
        List<Set<String>> first = new ArrayList<>();
        first.add(new HashSet<>());
        map.put(0, first);

        for (int i = 1; i <= len; i++) {
            List<Set<String>> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (!map.get(j).isEmpty() && dict.contains(sub)) {
                    for (Set<String> set : map.get(j)) {
                        if (!set.contains(sub)) {
                            Set<String> copy = new HashSet<>(set);
                            copy.add(sub);
                            cur.add(copy);
                        }
                    }
                }
            }
            map.put(i, cur);
        }
        return !map.get(len).isEmpty();
    }



    public static void main(String[] args) {
        String s = "ppfoobarppbarfoo";
        String a = "dlmogiklbqfggokuonfgugiyammwvwhbjvrqgdbjtipcwzwmobtjjdhmpvknrsqbpjtvmwfifukbwgokjjvvmeheatttljwdupygofotcywygmksvipkmyqmrjifueiouiukoldqlzquocojkdvzdlnuuvbqajewubgiolazmsvaujmfohervtorppipbolvrtdfefhqxcrrofycmewjykbnzjeazrxrkayohfgekzwyewctbyczidokoskojihvkflslryxruvxrzquytvgyjsndddmnkhzrstclsbeowchwsbwnwemhxbkcgwpqfqjzmmlenpumrckmdgzcmnjjqulwscoytyxhkklzahntjzfphhruwadnwpjptypmwovizijzqzuzycogjhahkdugugxoemccbymagvbyuxytzobkwbsigoobuoraatedrqfamiyigydhpeslhmvoajrxzixabcfvslxgvvpbwujlzdygptureloetogxslsmyrtuokxkeivflvmcoiutwkzryfoqsidtzypqkmaqxywktknisjdoteisjykdhpyipnyzcbqzzolsyycsjfjdjrxupjayzyhqohqqiirjyccwdgoomxtxqqugcwedwntkxlcfvvrtatpfbgtnfnnwfjchfikdwgotrsanorgqmyvoeqdldshldlsiufoslencwprmhyevwzlcqrpvlzgpkbzggnytrnxqdpekpjhnivraogwzfeoqfoynbzgvmelpvpbkyjxjgojuwhtcmkurysfbrnwerjvozxazixionukkbfonpihpcorwbpcvzxjaukzejksxeejhkxxzhgpjuihvxjqyhaydmaivkcuqhdztcyulelvyteutokrxmscasmwepswyyxrawnmazjbsnvndhfcwzfwrruxinvilsbnopbroksiapwfydkwcptvipstepbphffyugrktlsvaqaatkxxbssmhmhmbidjpijjravklofnghnaumxvesjoeqcibhtqsccjextpnaeuhtwdgvbknkaubccemvuezyndwiujkyftrbxxzykmkkilpkrdhohgmwjigduqdbjvdgueggqrtbeknwnvkubysnjysdowgztjipnowghpjmbwkorwkvuckfaciqaprvazlqqjyxahlbdxpxvzusdexfiivlzogbotrgerfeathgqydmxzgcddhnleykthmjcfphzwnzpvfgtkutjavoffcrjcdejrpoxevydkxsffabruwbwtrcytvkyyqhqgvpmsnpdmiktinlflmdffffzcrxbigtqeicyxudlcofmdqtpexwjebkhtjidsdtwlvwkpavtqaitsbkyagifiumdewgwzzumwqyoqtjgwrcqvmpvtzadtogxmmvnlrzjixxathjpylhvzwruvtxpkdowrmkedlonjloeuxtvkcqjzjeuddlnhalamvfrhvfsitwdsryetqnu";
        String[] b = {"pbolvrtdfefhqxcrrofyc","mewjykbnzjeazrxrkayoh","fgekzwyewctbyczidokos","kojihvkflslryxruvxrzq","uytvgyjsndddmnkhzrstc","lsbeowchwsbwnwemhxbkc","gwpqfqjzmmlenpumrckmd","gzcmnjjqulwscoytyxhkk","lzahntjzfphhruwadnwpj","ptypmwovizijzqzuzycog","jhahkdugugxoemccbymag","vbyuxytzobkwbsigoobuo","raatedrqfamiyigydhpes","lhmvoajrxzixabcfvslxg","vvpbwujlzdygptureloet","ogxslsmyrtuokxkeivflv","mcoiutwkzryfoqsidtzyp","qkmaqxywktknisjdoteis","jykdhpyipnyzcbqzzolsy","ycsjfjdjrxupjayzyhqoh","qqiirjyccwdgoomxtxqqu","gcwedwntkxlcfvvrtatpf","bgtnfnnwfjchfikdwgotr","sanorgqmyvoeqdldshldl","siufoslencwprmhyevwzl","cqrpvlzgpkbzggnytrnxq"};
        String[] dict = {"foo","bar"};
        Solution so = new Solution();
        // System.out.println(so.findSubstring(s, dict));
        System.out.println(so.findSubstring(a, b));
    }
}