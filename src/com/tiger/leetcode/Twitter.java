package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tigerzhang on 16/6/14.
 */
public class Twitter {
    private Map<Integer, Set<Integer>> relationMap;
    private Map<Integer, LinkedList<Integer>> twitterMap;
    private Map<Integer, Integer> stampsMap;
    private int id = 0;

    private class TwitterNode implements Comparable<TwitterNode>{
        int currentValue;
        Iterator<Integer> iterator;

        public TwitterNode(Iterator<Integer> iterator) {
            this.iterator = iterator;
            next();
        }

        public int compareTo(TwitterNode o) {
            return  stampsMap.get(currentValue) - stampsMap.get(o.currentValue);
        }

        public void next(){
            if(iterator.hasNext()){
                currentValue = iterator.next();
            }else {
                currentValue = -1;
            }
        }

        public boolean isEmpty() {
            return currentValue == -1;
        }

        public int getCurrentValue() {
            return currentValue;
        }

        @Override
        public int hashCode() {
            return this.iterator.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            TwitterNode other = (TwitterNode)obj;
            return this.iterator == other.iterator && this.currentValue == other.currentValue;
        }
    }


    /** Initialize your data structure here. */
    public Twitter() {
        relationMap = new HashMap<Integer, Set<Integer>>();
        twitterMap = new HashMap<Integer, LinkedList<Integer>>();
        stampsMap = new HashMap<Integer, Integer>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!twitterMap.containsKey(userId)){
            twitterMap.put(userId, new LinkedList<Integer>());
        }
        twitterMap.get(userId).addFirst(tweetId);
        stampsMap.put(tweetId, id++);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<Integer>();
        Set<Integer> users = relationMap.get(userId);

        if(users == null){
            users = new HashSet<Integer>();
        }
        users.add(userId);

        TreeSet<TwitterNode> treeSet = new TreeSet<TwitterNode>();
        for(Integer user: users){
            if(twitterMap.get(user) != null){
                treeSet.add(new TwitterNode(twitterMap.get(user).iterator()));
            }
        }

        int count = 0;
        while (count < 10 && !treeSet.isEmpty()){
            TwitterNode node = treeSet.last();
            ret.add(node.getCurrentValue());
            treeSet.remove(node);
            node.next();
            if(!node.isEmpty()) {
                treeSet.add(node);
            }
            count++;
        }

        return ret;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!relationMap.containsKey(followerId)){
            relationMap.put(followerId, new HashSet<Integer>());
        }
        relationMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(relationMap.containsKey(followerId)){
            relationMap.get(followerId).remove(followeeId);
        }
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.unfollow(1, 2);
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
//        twitter.follow(2, 1);
////        twitter.postTweet(2, 6);
//        System.out.println(twitter.getNewsFeed(2));
//        twitter.unfollow(2, 1);
//        System.out.println(twitter.getNewsFeed(2));
    }
}
