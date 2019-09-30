package kakao;

import java.util.*;

/**
 * Created by ykb on 2019-07-27.
 */
public class Result {


    public static void main(String[] args) {
//        System.out.println(numOflds2("0011223344556677889988"));
//        System.out.println("888888555555555555555".length());

        List<Integer> sss = new ArrayList<>();
//        sss.add(4);
//        sss.add(2);
//        sss.add(3);
        sss.add(0);
        sss.add(2);
        sss.add(6);

        for(Integer i : sss) {
            System.out.println(i%4);
        }
        System.out.println("--------------------");
        List<Integer> result = sentTimes(4, 2, sss);

        for(Integer i : result) {
            System.out.println(i);
        }
//        System.out.println("0011223344556677889988".length());
    }

    public static int numOflds(String pool) {
        int poolLen = pool.length();
        int len = poolLen/8;
        int count_8 = 0;

        if(poolLen < 100 && poolLen > 1) {
            for(int i = 0; i < poolLen; i++) {
                if((int)pool.charAt(i) == 56) {
                    count_8++;
                }
            }

            if(count_8 < len) {
                return count_8;
            } else {
                return len;
            }
        }

        return 0;
    }

    public static int numOflds2(String pool) {
        int poolLen = pool.length();
        int count_8 = 0;
        int count_other = 0;
        int count_temp = 0;

        if(poolLen < 100 && poolLen > 1) {
            for(int i = 0; i < poolLen; i++) {
                if(pool.charAt(i) == '8') {
                    count_8++;
                } else {
                    count_temp++;
                }
            }

            count_other = count_temp/10;
            if(count_8 == 0) {
                return count_8;
            } else {
                if(count_other > count_8) {
                    return count_8;
                } else {
                    return count_other;
                }
            }
        }

        return 0;
    }

    public static int numOflds3(String pool) {
        int poolLen = pool.length();
        int flag[] = new int[poolLen];
        int temp_i = 0;

        if(poolLen < 100 && poolLen > 1) {
            for(int i = 0; i < poolLen; i++) {
                if(pool.charAt(i) == '8' && flag[i] == 0) {
                    flag[i] = 1;
                    for(int j = 0; j < poolLen; j++)
                    {
                        if(flag[j] == 0)
                        {
                            flag[j] = 1;
                            temp_i++;
                        }

                    }
                }
            }
        }

        return temp_i/10;
    }

    public static String calPool (int start, int end, String pool) {
        return pool.substring(start, end);
    }

    public static List<String> funWithAnagrams(List<String> s) {
        Map<String, String> map = new HashMap<>();
        String[] temp;
        String str = "";
        List<String> result = new ArrayList<>();
        for(String i : s) {
            temp = i.split("");
            Arrays.sort(temp);
            for(int j = 0; j < temp.length; j++) {
                str += temp[j];
            }

            if(map.get(str) == null) {
                map.put(str, i);
            }
            str = "";
        }

        for(String key : map.keySet()) {
            result.add(map.get(key));
        }

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return result;
    }

    /*
    * 1 <= numberOfPorts <= 2000
    * 1 ≤ transmissionTime ≤ 100
    * 1 ≤ x ≤ 2000
    * 1 ≤ packetIdsi ≤ 105
    * */

    public static List<Integer> sentTimes(int numberOfPorts, int transmissionTime, List<Integer> packetIds) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int hash = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < packetIds.size(); i++) {
            hash = packetIds.get(i) % numberOfPorts;
            if(hash <= numberOfPorts - 1) {
                if(map.get(hash) == null) {
                    map.put(hash, transmissionTime);
                    result.add(hash);
                } else {
                    while(true) {
                        if(map.get(hash) != null) {
                            map.put(hash, map.get(hash));
                            if(map.get(hash) > 0) {
                                hash++;
                                continue;
                            } else {
                                if (hash <= numberOfPorts) {
                                    break;
                                } else {
                                    hash = packetIds.get(i) % numberOfPorts;
                                }
                            }
                        } else {
                            map.put(hash, transmissionTime);
                            result.add(hash);
                            break;
                        }
                    }
                }
            }
            for(int key : map.keySet()) {
                map.put(key, map.get(key)-1);
            }
        }

        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        return result;
    }

    public static int checkTime(int numberOfPorts, int hash, Map<Integer, Integer> map, boolean flag) {
        if(map.get(hash) != null) {
            map.put(hash, map.get(hash) - 1);
            if(map.get(hash) > 0) {
                if(hash <= numberOfPorts) {
                    checkTime(numberOfPorts, hash + 1, map, true);
                }
            }
        }

        return hash;
    }
}


//0