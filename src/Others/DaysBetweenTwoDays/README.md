## A:计算两个日期之间的天数

- 总时间限制: 

  1000ms

- 内存限制: 

  65536kB


- 描述

  给定两个日期，计算相差的天数。比如2010-1-1和2010-1-3相差2天。

- 输入

  共两行：第一行包含三个整数startYear，startMonth，startDay，分别是起始年、月、日。第二行包含三个整数endYear，endMonth，endDay，分别是结束年、月、日。相邻两个整数之间用单个空格隔开。年份范围在1~3000。保证日期正确且结束日期不早于起始日期。

- 输出

  输出一个整数，即是两个日期相差的天数。

- 样例输入

  `2008 1 1`

  `2009 1 1`

- 样例输出

  `366`

- 提示

  闰年被定义为能被4整除的年份，但是能被100整除而不能被400整除的年是例外，它们不是闰年。闰年的2月份有29天。