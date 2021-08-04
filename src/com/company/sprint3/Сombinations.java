package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Сombinations {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> keysMap = new HashMap<>();
        keysMap.put(2, "abc");
        keysMap.put(3, "def");
        keysMap.put(4, "ghi");
        keysMap.put(5, "jkl");
        keysMap.put(6, "mno");
        keysMap.put(7, "pqrs");
        keysMap.put(8, "tuv");
        keysMap.put(9, "wxyz");
        phoneCombinations(reader.readLine(), keysMap);
    }

    public static void phoneCombinations(String inputKeys, Map<Integer, String> keysMap) throws Exception {
        validateKeys(inputKeys);
        int[] inputKeysArr = Arrays.stream(inputKeys.split("")).mapToInt(Integer::parseInt).toArray();
        String[] first = (keysMap.get(inputKeysArr[0])).split("");
        String[] second = (keysMap.get(inputKeysArr[1])).split("");
        String[] third = new String[0];
        String[] fourth = new String[0];
        String[] fifth = new String[0];
        String[] sixth = new String[0];
        String[] seventh = new String[0];
        String[] eighth = new String[0];
        String[] ninth = new String[0];
        String[] tenth = new String[0];
        StringBuilder out = new StringBuilder();
        if (inputKeysArr.length > 2) {
            third = (keysMap.get(inputKeysArr[2])).split("");
        }
        if (inputKeysArr.length > 3) {
            fourth = (keysMap.get(inputKeysArr[3])).split("");
        }
        if (inputKeysArr.length > 4) {
            fifth = (keysMap.get(inputKeysArr[4])).split("");
        }
        if (inputKeysArr.length > 5) {
            sixth = (keysMap.get(inputKeysArr[5])).split("");
        }
        if (inputKeysArr.length > 6) {
            seventh = (keysMap.get(inputKeysArr[6])).split("");
        }
        if (inputKeysArr.length > 7) {
            eighth = (keysMap.get(inputKeysArr[7])).split("");
        }
        if (inputKeysArr.length > 8) {
            ninth = (keysMap.get(inputKeysArr[8])).split("");
        }
        if (inputKeysArr.length > 9) {
            tenth = (keysMap.get(inputKeysArr[9])).split("");
        }
        switch (inputKeysArr.length) {
            case 2: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        out.append(first[i]).append(second[j]).append(" ");
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            out.append(first[i]).append(second[j]).append(third[k]).append(" ");
                        }
                    }
                }
                break;
            }
            case 4: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(" ");
                            }
                        }
                    }
                }
            }
            case 5: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                for (int m = 0; m < fifth.length; m++) {
                                    out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(fifth[m]).append(" ");
                                }
                            }
                        }
                    }
                }
            }
            case 6: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                for (int m = 0; m < fifth.length; m++) {
                                    for (int n = 0; n < sixth.length; n++) {
                                        out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(fifth[m]).append(sixth[n]).append(" ");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            case 7: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                for (int m = 0; m < fifth.length; m++) {
                                    for (int n = 0; n < sixth.length; n++) {
                                        for (int o = 0; o < seventh.length; o++) {
                                            out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(fifth[m]).append(sixth[n]).append(seventh[o]).append(" ");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            case 8: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                for (int m = 0; m < fifth.length; m++) {
                                    for (int n = 0; n < sixth.length; n++) {
                                        for (int o = 0; o < seventh.length; o++) {
                                            for (int p = 0; p < eighth.length; p++) {
                                                out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(fifth[m]).append(sixth[n]).append(seventh[o]).append(eighth[p]).append(" ");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            case 9: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                for (int m = 0; m < fifth.length; m++) {
                                    for (int n = 0; n < sixth.length; n++) {
                                        for (int o = 0; o < seventh.length; o++) {
                                            for (int p = 0; p < eighth.length; p++) {
                                                for (int q = 0; q < ninth.length; q++) {
                                                    out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(fifth[m]).append(sixth[n]).append(seventh[o]).append(eighth[p]).append(ninth[q]).append(" ");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            case 10: {
                for (int i = 0; i < first.length; i++) {
                    for (int j = 0; j < second.length; j++) {
                        for (int k = 0; k < third.length; k++) {
                            for (int l = 0; l < fourth.length; l++) {
                                for (int m = 0; m < fifth.length; m++) {
                                    for (int n = 0; n < sixth.length; n++) {
                                        for (int o = 0; o < seventh.length; o++) {
                                            for (int p = 0; p < eighth.length; p++) {
                                                for (int q = 0; q < ninth.length; q++) {
                                                    for (int r = 0; r < tenth.length; r++) {
                                                        out.append(first[i]).append(second[j]).append(third[k]).append(fourth[l]).append(fifth[m]).append(sixth[n]).append(seventh[o]).append(eighth[p]).append(ninth[q]).append(tenth[r]).append(" ");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.print(out);

    }

    public static void validateKeys(String keys) throws Exception {
        if (!keys.matches("[2-9]+") || (keys.length() > 10)) {
            throw new Exception();
        }
    }
}
