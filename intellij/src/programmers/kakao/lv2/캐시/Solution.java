package programmers.kakao.lv2.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<City> cache = new ArrayList<>();
        String city;

        for (int time = 0; time < cities.length; time++) {
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            city = cities[time].toLowerCase();

            if (contains(city, cache)) {
                int index = getIndex(city, cache);
                cache.get(index).lastUsedTime = time;
                answer++;
            } else {
                if (cache.size() == cacheSize) {
                    int index = getLastUsedCityIndex(cache);
                    cache.remove(index);
                }
                answer += 5;
                cache.add(0, new City(city, time));
            }
        }
        return answer;
    }

    private int getIndex(String cityName, ArrayList<City> cache) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).name.equals(cityName)) {
                return i;
            }
        }

        return -1;
    }

    private boolean contains(String cityName, ArrayList<City> cache) {
        for (City city : cache) {
            if (city.name.equals(cityName)) {
                return true;
            }
        }

        return false;
    }

    private int getLastUsedCityIndex(ArrayList<City> cache) {
        int index = -1;
        int minLastUsedTime = Integer.MAX_VALUE;
        for (int i = 0; i < cache.size(); i++) {
            City city = cache.get(i);
            if (city.lastUsedTime < minLastUsedTime) {
                minLastUsedTime = city.lastUsedTime;
                index = i;
            }
        }

        return index;
    }
}

class City {
    String name;
    int lastUsedTime;

    public City(String name, int lastUsedTime) {
        this.name = name;
        this.lastUsedTime = lastUsedTime;
    }
}
