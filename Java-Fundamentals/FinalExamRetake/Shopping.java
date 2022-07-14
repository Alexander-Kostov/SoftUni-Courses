package FinalExamRetake;

import java.util.*;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<String>> notepad = new LinkedHashMap<>();
        List<String> importantItems = new ArrayList<>();

        while (!line.equals("Go Shopping")) {
            String[] data = line.split("->");
            String command = data[0];


            switch (command) {
                case "Add":
                    String store = data[1];
                    notepad.putIfAbsent(store, new ArrayList<>());
                    String[] items = data[2].split(",");
                    List<String> another = new ArrayList<>();
                    for (String item : items) {
                        another.add(item);
                    }
                    List<String> itemsToAdd = new ArrayList<>();
                    for (String s : another) {
                        itemsToAdd.add(s);
                    }


                    for (int i = 0; i < another.size(); i++) {
                        for (Map.Entry<String, List<String>> entry : notepad.entrySet()) {
                            for (int j = 0; j < entry.getValue().size(); j++) {
                                String item = entry.getValue().get(j);
                                String itemToCompare = another.get(i);
                                if (item.equals(itemToCompare)) {
                                    itemsToAdd.remove(item);
                                }
                            }
                        }
                    }

                    for (String s : itemsToAdd) {
                        notepad.get(store).add(s);
                    }

                    break;
                case "Important":
                    String secondStore = data[1];
                    String importantItem = data[2];
                    boolean foundItem = false;
                    String foundInStore = "";

                    for (Map.Entry<String, List<String>> entry : notepad.entrySet()) {
                        for (String s : entry.getValue()) {
                            if (s.equals(importantItem)) {
                                foundItem = true;
                                foundInStore = entry.getKey();
                                break;
                            }
                            if (foundItem) {
                                break;
                            }
                        }
                    }

                    if (foundItem && !notepad.containsKey(secondStore)) {
                        notepad.put(secondStore, new ArrayList<>());
                        notepad.get(secondStore).add(importantItem);
                        importantItems.add(importantItem);
                    } else if (foundItem && notepad.containsKey(secondStore)) {
                        notepad.get(foundInStore).remove(importantItem);
                        notepad.get(foundInStore).add(0,importantItem);
                        importantItems.add(importantItem);
                    }else if (!foundItem && notepad.containsKey(secondStore)){
                        notepad.get(secondStore).add(0,importantItem);
                        importantItems.add(importantItem);
                    }else if (!foundItem && !notepad.containsKey(secondStore)){
                        notepad.put(secondStore,new ArrayList<>());
                        notepad.get(secondStore).add(importantItem);
                        importantItems.add(importantItem);
                    }


                    break;
                case "Remove":
                    String market = data[1];
                    boolean itemFound = false;
                    for (int i = 0; i < importantItems.size(); i++) {
                        String currentItem = importantItems.get(i);
                        for (Map.Entry<String, List<String>> entry : notepad.entrySet()) {
                            for (int j = 0; j < entry.getValue().size(); j++) {
                                if (currentItem.equals(entry.getValue().get(i))) {
                                    itemFound = true;
                                    break;
                                }
                                if (itemFound) {
                                    break;
                                }
                            }
                        }
                    }
                    if (!itemFound) {
                        notepad.remove(market);
                    }

                    break;
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : notepad.entrySet()) {
            System.out.printf("%s: \n", entry.getKey());
            for (String s : entry.getValue()) {
                System.out.printf(" - %s\n", s);
            }
        }
    }
}
