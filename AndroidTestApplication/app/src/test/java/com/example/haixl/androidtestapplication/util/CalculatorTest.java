package com.example.haixl.androidtestapplication.util;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.junit.Assert.*;

/**
 * @author zhaosw.
 * @date 2019/2/22.
 */
@PrepareForTest(Calculator.class)
@RunWith(PowerMockRunner.class)
public class CalculatorTest {

//    @Rule
//    public PowerMockRule powerMockRule = new PowerMockRule();

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
    }

    @Test
    public void getNum() {
    }

    @Test
    public void getTimes() {
    }

    @Test
    public void testStaticDec() {
        PowerMockito.mockStatic(Calculator.class);
        PowerMockito.when(Calculator.decStatic(1,2)).thenReturn(-2);
        Calculator calculator = new Calculator();
        assertEquals(-2,calculator.dec(1,2));
    }

    @Test
    public void testPrivateAddMulti() throws Exception {
        Calculator calculator = PowerMockito.mock(Calculator.class);
        PowerMockito.when(calculator.addMulti(1,1)).thenCallRealMethod();
//        mock 私有方法
        PowerMockito.when(calculator,"addMultiPrivate",ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt()).thenReturn(3);
        assertEquals(3,calculator.addMulti(1,1));

        Calculator calculator1 = new Calculator();
//        跳过方法
        PowerMockito.suppress(PowerMockito.method(Calculator.class, "addMultiPrivate"));
        assertEquals(0,calculator1.addMulti(1,2,3));
    }

    @Test
    public void testFinalGetRendom() {
        Calculator calculator = PowerMockito.mock(Calculator.class);
//        mock final 方法
        PowerMockito.when(calculator.getRendomFinal()).thenReturn(1);
        PowerMockito.when(calculator.getRendom()).thenCallRealMethod();
        assertEquals(1,calculator.getRendom());
    }

    @Test
    public void testConstruction() throws Exception {
//        创建模拟好的对象
        CalculatorHelper calculatorHelper = PowerMockito.mock(CalculatorHelper.class);
        PowerMockito.when(calculatorHelper.getTimes()).thenReturn(111);
//        calculatorHelper替换new CalculatorHelper()时返回的对象
        PowerMockito.whenNew(CalculatorHelper.class).withArguments(100).
                thenReturn(calculatorHelper);
        Calculator calculator = new Calculator();
        assertEquals(111,calculator.getTimes());
    }


}