package com.example.haixl.androidtestapplication.util;

import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author zhaosw.
 * @date 2019/2/20.
 */
public class Parameters {

    @Parameterized.Parameters
    public static Collection<Object> data(){
        List<Object> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{-1, -2, -3});
        list.add(new int[]{1, -1, 0});
        list.add(new int[]{0, 1, 2});
        return list;
    }

    @Parameterized.Parameter(0)
    public int input_a;
    @Parameterized.Parameter(1)
    public int input_b;
    @Parameterized.Parameter(2)
    public int output_a;

}
