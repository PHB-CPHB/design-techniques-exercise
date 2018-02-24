/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designtechnuquesexercise;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author philliphbrink
 */
public class MyArrayListWithBugsTest {
    
    private MyArrayListWithBugs arrayList;
    
    //TC 1
    @Before
    public void before() {
        System.out.println("Create an instance of MyArrayListWithBugs");
        this.arrayList = new MyArrayListWithBugs();
        Assert.assertEquals(0, this.arrayList.size());
    }

    /**
     * TC 2
     * Add object to empty MyArrayListWithBugs
     */
    @Test
    public void addTest1() {
        System.out.println("Add object to empty MyArrayListWithBugs");
        String test = "test 2";
        arrayList.add(test);
        Assert.assertEquals(1, arrayList.size());
        Assert.assertEquals(test, arrayList.get(0));
    }
    
    /**
     * TC 3
     * Add object to not empty MyArrayListWithBugs
     */
    @Test
    public void addTest2() {
        System.out.println("Add object to not empty MyArrayListWithBugs");
        addTest1();
        String test = "test 3";
        arrayList.add(test);
        Assert.assertEquals(2, arrayList.size());
        Assert.assertEquals(test, arrayList.get(1));
    }
    
    /**
     * TC 4
     * Add object on index to empty MyArrayListWithBugs
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void addTest3() {
        System.out.println("Add object on index to empty MyArrayListWithBugs");
        String test = "Test 4";
        arrayList.add(0, test);
    }
    
    /**
     * TC 5
     * Add object on index to not empty MyArrayListWithBugs
     */
    @Test
    public void addTest4() {
        System.out.println("Add object on index to not empty MyArrayListWithBugs");
        addTest1();
        String test = "Test 5";
        String firstIndex = (String) arrayList.get(0);
        arrayList.add(0, test);
        Assert.assertTrue(arrayList.size()>1);
        Assert.assertEquals(test, arrayList.get(0));
        Assert.assertEquals(firstIndex, arrayList.get(1));
    }
    
    /**
     * TC 6
     * Remove object on index on empty MyArrayListWithBugs
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeTest1() {
        System.out.println("Remove object on index on empty MyArrayListWithBugs");
        arrayList.remove(0);
    }
    
    /**
     * TC 7
     * Remove object on index on not empty MyArrayListWithBugs
     */
    @Test
    public void removeTest2() {
        System.out.println("Remove object on index on not empty MyArrayListWithBugs");
        addTest1();
        arrayList.remove(0);
        Assert.assertEquals(0, arrayList.size());
        
    }
    
    /**
     * TC 8
     * Remove object on index on not empty MyArrayListWithBugs which has a size larger than 2 
     */
    @Test
    public void removeTest3() {
        System.out.println("Remove object on index on not empty MyArrayListWithBugs which has a size larger than 2 ");
        addTest2();
        arrayList.remove(0);
        Assert.assertEquals(1, arrayList.size());
    }
    
    /**
     * TC 9
     * Add object to the last index of an not empty MyArratListWithBugs
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void addTest5() {
        System.out.println("Add object to the last index of an not empty MyArratListWithBugs");
        addTest4();
        String test = "Baclk box";
        arrayList.add(2, test);
    }
}
