package programmers.kakao.lv3.매칭점수;

import java.util.*;

class Solution {
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        HashMap<String, PageInfo> pageInfoMap = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            String lowerCasePage = pages[i].toLowerCase();
            int count = getCount(lowerCasePage, word);
            String url = getUrl(lowerCasePage);
            PageInfo pageInfo = new PageInfo(i, url, count, getLinks(lowerCasePage));
            pageInfoMap.put(url, pageInfo);
        }

        for (String url : pageInfoMap.keySet()) {
            PageInfo pageInfo = pageInfoMap.get(url);
            for (String link : pageInfo.links) {
                PageInfo linkPageInfo = pageInfoMap.get(link);
                if (linkPageInfo != null) {
                    linkPageInfo.linkPoint += (double) pageInfo.basicPoint / pageInfo.links.size();
                }
            }
        }

        double maxPoint = -1;
        int index = -1;
        for (String url : pageInfoMap.keySet()) {
            PageInfo pageInfo = pageInfoMap.get(url);
            double totalPoint = pageInfo.basicPoint + pageInfo.linkPoint;
            if (totalPoint > maxPoint) {
                maxPoint = totalPoint;
                index = pageInfo.index;
            } else if (totalPoint == maxPoint) {
                index = Math.min(index, pageInfo.index);
            }
            // System.out.println(url + " " + pageInfo.basicPoint + " " + pageInfo.links.size() + " " + pageInfo.linkPoint);
        }

        // System.out.println(maxPoint + " " + index);

        return index;
    }

    private int getCount(String page, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : page.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            } else {
                if (sb.length() > 0 && word.equals(sb.toString())) {
                    count++;
                }
                sb.setLength(0);
            }
        }

        if (sb.length() > 0 && word.equals(sb.toString())) {
            count++;
        }
        return count;
    }

    private ArrayList<String> getLinks(String page) {
        ArrayList<String> links = new ArrayList<>();
        String[] splitPage = page.split("<a href=\"");

        StringBuilder sb = new StringBuilder();
        for (String str : splitPage) {
            int index = str.indexOf("\">");
            if (!str.startsWith("https://") || index == -1) {
                continue;
            }

            links.add(str.substring(0, index));
        }

        return links;
    }

    private String getUrl(String page) {
        StringBuilder sb = new StringBuilder();
        String content = "<meta property=\"og:url\" content=\"";
        int index = page.indexOf(content) + content.length();
        while (true) {
            char c = page.charAt(index++);
            if (c == '"') {
                break;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}

class PageInfo {
    int index;
    String url;
    int basicPoint;
    double linkPoint;
    ArrayList<String> links;

    public PageInfo(int index, String url, int basicPoint, ArrayList<String> links) {
        this.index = index;
        this.url = url;
        this.basicPoint = basicPoint;
        this.links = links;
    }
}
