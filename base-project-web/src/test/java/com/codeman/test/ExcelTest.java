// package com.codeman.test;
//
// import cn.hutool.core.date.DateTime;
// import cn.hutool.core.date.DateUtil;
// import cn.hutool.core.util.IdcardUtil;
// import cn.hutool.poi.excel.ExcelReader;
// import cn.hutool.poi.excel.ExcelUtil;
// import org.junit.Test;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
//
// public class ExcelTest {
//  @Test
//  public void test() {
//    ExcelReader reader = ExcelUtil.getReader("/Users/tanghailan/Desktop/20220409/管控区-人口数据.xlsx");
//    ExcelReader readerFkq = ExcelUtil.getReader("/Users/tanghailan/Desktop/20220409/管控区.xls");
//    List<Map<String, Object>> readAll = reader.readAll();
//    List<Map<String, Object>> fkqReadAll = readerFkq.readAll();
//    // 海珠一张图圈选
//    List<String> list1 = new ArrayList<>();
//    // 人口大数据
//    List<String> list2 = new ArrayList<>();
//    for (Map<String, Object> people : readAll) {
//      list1.add(people.get("NAME").toString() + people.get("BIRTH_DAY"));
//    }
//
//    for (Map<String, Object> people : fkqReadAll) {
//      DateTime barthDay = IdcardUtil.getBirthDate(people.get("证件号码").toString());
//      String format = DateUtil.format(barthDay, "yyyy-MM-dd 00:00:00");
//      list2.add(people.get("人员姓名").toString() + format);
//    }
//
//    // 交集
//    List<String> intersection =
// list1.stream().filter(list2::contains).collect(Collectors.toList());
//    // System.out.println(intersection);
//    System.out.println("交集长度：" + intersection.size());
//
//    // 差集 (list2 - list1)
//    List<String> reduce1 =
//        list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
//    System.out.println("---差集 reduce1 (list2 - list1)---");
//    reduce1.parallelStream().forEach(System.out::println);
//    System.out.println("差集 (list2 - list1)" + reduce1.size());
//
//    // 差集 (list1 - list2)
//    List<String> reduce2 =
//        list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
//    System.out.println("---差集 reduce1 (list1 - list2)---");
//    reduce2.parallelStream().forEach(System.out::println);
//    System.out.println("差集 (list1 - list2)" + reduce2.size());
//
//    // List<String> listAll = list1.parallelStream().collect(Collectors.toList());
//    // List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
//    // listAll.addAll(listAll2);
//    // System.out.println("---并集 listAll---");
//    // listAll.parallelStream().forEachOrdered(System.out::println);
//    // System.out.println(listAll.size());
//  }
// }
