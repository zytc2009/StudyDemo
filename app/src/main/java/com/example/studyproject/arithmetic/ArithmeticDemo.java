package com.example.studyproject.arithmetic;

import com.example.studyproject.arithmetic.bean.Node;
import com.example.studyproject.arithmetic.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ArithmeticDemo {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();

//        test4();
//          test5();

//        test6();

//        test7();

        int[] element = new int[]{1,2,3,2,2,2,5,4,2};
        majorityElement(element);
    }

    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     *
     * 思路：对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求找出重复的数字，
     * 因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     * */
    public static void test1(){

        int[] array = new int[]{5, 4, 1, 1, 3, 2};

        for (int i = 0 ; i < array.length ; i++){
            System.out.println("外循环 i = " + i);
            while (i != array[i]){
                System.out.println("while i = " + i + "；array[i] = " + array[i]);
                if ( array[i] != array[array[i]]){
                    System.out.println("交换 array[i] = " + array[i] + "；array[array[i]]=" +array[array[i]]);
                    int temp = array[array[i]];
                    array[array[i]] = array[i];
                    array[i] = temp;
                }else{
                    System.out.println("重复数字 = " + array[i]);
                    return;
                }
            }

        }

    }



    /**
     * 给定一个二维数组，其每一行从左到右递增排序，
     * 从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     *
     * 思路：该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
     * 就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
     * */
    public static void test2(){

        int[][] array = new int[5][5];
        array[0] = new int[]{1,   4,  7, 11, 15};
        array[1] = new int[]{2,   5,  8, 12, 19};
        array[2] = new int[]{3,   6,  9, 16, 22};
        array[3] = new int[]{10, 13, 14, 17, 24};
        array[4] = new int[]{18, 21, 23, 26, 30};

        int searchNum = 35;
        int i = 0;
        int subLength = array[i].length  - 1;
        while (i < array.length){
            System.out.println("while i =  " + i + "；subLength = " + subLength);
            if (searchNum == array[i][subLength]){
                System.out.println("查找到数字 = " + searchNum);
                break;
            }else if (searchNum < array[i][subLength]){
                subLength-- ;
            }else{
                i++;
            }
        }

    }

    /**
     * 将一个字符串中的空格替换成 "%20"
     *
     * Input:
     * "A B"
     *
     * Output:
     * "A%20B"
     * */
    public static void test3(){

        String s = "A B";
        StringBuilder sb = new StringBuilder(s);
        int p1 = sb.length() -1;
        for (int i = 0 ; i <= p1 ; i++){
            if (sb.charAt(i) == ' '){
                sb.append("  ");
                break;
            }
        }

        int p2 = sb.length()-1;

        sb.setCharAt(p2, sb.charAt(p1));
        sb.setCharAt(--p2, '0');
        sb.setCharAt(--p2, '2');
        sb.setCharAt(--p2, '%');

        System.out.println("p1 = " + p1 +  ";p2 = " + p2 + ";result = " + sb.toString());

    }

    /**
     * 例：有一个数组[5,2,-1,0,7,4,0,9]
     * 输出：[5,2,-1,7,4,9,0,0]
     * */
    public static void test4(){

        int array[] = new int[]{0,2,-1,0,7,4,0,9};
        int p = 0;
        for (int i = 0 ;i < array.length; i++){
            if (array[i] != 0){
                int temp = array[p];
                array[p] = array[i];
                array[i] = temp;
                p++;
            }
        }
        System.out.println(Arrays.toString(array));

    }

    /**
     * 从尾到头反过来打印出每个结点的值。
     * */
    public static void test5(){

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;


//        List<Integer> list = reverseNode1(node1);
//        List<Integer> list = reverseNode2(node1);
        List<Integer> list = reverseNode3(node1);
        System.out.println(Arrays.toString(list.toArray()));

    }

    public static ArrayList<Integer> reverseNode1(Node node){
        ArrayList<Integer> array = new ArrayList<Integer>();
        if (node != null){
            array.addAll(reverseNode1(node.next));
            array.add(node.data);
        }
        return array;
    }

    public static ArrayList<Integer> reverseNode2(Node node){
        ArrayList<Integer> array = new ArrayList<Integer>();

        Node head = new Node(-1);
        while (node != null){
            Node temp = node.next;

            node.next = head.next;
            head.next = node;

            node = temp;
        }

        head = head.next;
        while (head != null){
            array.add(head.data);
            head = head.next;
        }

        return array;
    }

    public static ArrayList<Integer> reverseNode3(Node node){
        ArrayList<Integer> array = new ArrayList<Integer>();

        Stack<Integer> stack = new Stack();
        while (node != null){
            stack.push(node.data);
            node = node.next;
        }

        while (!stack.empty()){
            array.add(stack.pop());
        }

        return array;
    }

    /**
     * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * 例：preorder:3,9,20,15,7
     *    inorder :9,3,15,20,7
     * */
    // 缓存中序遍历数组每个值对应的索引
    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();
    public static void test6(){
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] midOrder = new int[]{9,3,15,20,7};
        for (int i = 0; i < midOrder.length; i++){
            indexForInOrders.put(midOrder[i], i);
        }

        TreeNode treeNode = reConstructBinaryTree(preOrder, 0, preOrder.length - 1, 0);

        iteratorTree(treeNode);
    }

    /**
     * 遍历二叉树
     * */
    private static void iteratorTree(TreeNode treeNode){
        if (treeNode == null){
            return;
        }

        System.out.println("data = " + treeNode.data);

        iteratorTree(treeNode.left);
        iteratorTree(treeNode.right);
    }

    /**
     * @param pre 前序遍历数组
     * @param preLeft 前序遍历开始角标
     * @param preRright 前序遍历结束角标
     * */
    public static TreeNode reConstructBinaryTree(int[] pre,int preLeft, int preRright, int inLeft){
        if (preLeft > preRright || preLeft > pre.length-1){
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int inIndex = indexForInOrders.get(root.data);
        int leftTreeSize = inIndex - inLeft;
        System.out.println("index = " + inIndex + ";leftTreeSize = " + leftTreeSize + ";preLeft = " + preLeft + ";preRright = " + preRright);
        root.left = reConstructBinaryTree(pre, preLeft + 1 , preLeft + leftTreeSize, 0);
        root.right = reConstructBinaryTree(pre, preLeft + leftTreeSize + 1, preRright, inLeft + leftTreeSize + 1 );
        return root;
    }

    public static void test7(){

        boolean isOverflow = isOverflow(1147483647,1147483647);
        System.out.println("test7  isOverflow  = " + isOverflow);
    }

    public static boolean isOverflow(int x, int y) {
//        System.out.println("isOverflow x = " + Integer.toBinaryString(x) + ";y = " + Integer.toBinaryString(y) );
//        int r = x + y;
//        System.out.println("isOverflow r = " + Integer.toBinaryString(r));
//        int xr = (x ^ r);
//        System.out.println("isOverflow xr = " + Integer.toBinaryString(xr));
//        int yr = (y ^ r);
//        System.out.println("isOverflow yr = " + Integer.toBinaryString(yr));
//        int result = ((x ^ r) & (y ^ r));
//        System.out.println("isOverflow result = " + Integer.toBinaryString(result));
//        if (result < 0) {
//            return true;
//        }
//        return false;

        int add = x + y;
        System.out.println("x = " + x + ";y = " + y + ";add = " + add);
        if (x>0 && y >0 && add < 0){
            return true;
        }
        if (x < 0 && y < 0 && add > 0){
            return true;
        }
        return false;
    }

    public static int majorityElement(int[] nums) {

        int middleSize = nums.length%2 == 0 ? nums.length/2 : nums.length/2+1;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0 ; i < nums.length ; i++){
            int value = 0;
            if (map.containsKey(nums[i])){
                value = map.get(Integer.valueOf(nums[i]));
            }
            ++value;
            map.put(nums[i],Integer.valueOf(value));
        }

        for(Map.Entry entry : map.entrySet()){
            if((Integer)entry.getValue() >= middleSize){
                return (Integer) entry.getKey();
            }
        }

        return -1;

    }


}
