# Reflection and Annotations
Usages reflection and create annotatios examples

## 1.Reflection

Reflection is a feature in the Java programming language. It allows an executing Java program to examine or "introspect" upon itself, and manipulate internal properties of the program. For example, it's possible for a Java class to obtain the names of all its members and display them.

### 1.1.Basic map getters

> Source: [Getters Map](/codereusability/src/main/java/br/com/zherro/codereusability/reflection/c1_getter_map/GettersMap.java)

In this example we creates the getters map of any object pass as parameter.

### 1.2.Performance

> Source: [Test Perfomance](/codereusability/src/main/java/br/com/zherro/codereusability/reflection/c2_performance/TesteDesempenho.java)

When we use reflection must observe the performance of code created. Reflection can to add an additional cost to application execution, when not used with responsibility.

One reflection code dont prejudice your application, this is notable  just when a lot of reflections are executeds recursively or in a loop.  

Just to uses with prudence. =]

#### Tests

This tests uses a empty nethod in `reflection/c2_performance/ClasseTeste.java`


- **[InvocadorNormal](/codereusability/src/main/java/br/com/zherro/codereusability/reflection/c2_performance/InvocadorNormal.java) :** Executes the method directly.
- **[InvocadorReflexao](/codereusability/src/main/java/br/com/zherro/codereusability/reflection/c2_performance/InvocadorReflexao.java) :** Executes the method through of reflection, on each execution the method is recovered. 
- **[InvocadorReflexaoCache](/codereusability/src/main/java/br/com/zherro/codereusability/reflection/c2_performance/InvocadorReflexaoCache.java) :**  In this case the method is recovered one time e is run how many times necessary.

**Results of test**
- InvocadorNormal: normal execution `instance.method()`
- InvocadorReflexao: Recovering the method by reflection every interaction, the time of execution takes up to 20x longer.
- InvocadorReflexao Cache: Recovering the method by reflection one time, the time of execution takes up to 7x longer.

> The tests called the method 100000x for every case.

> Test results may vary depending on the processing power of the machine.

### 1.2.1.Getter Map Improving

> Source: [Getter Map Improving](/codereusability/src/main/java/br/com/zherro/codereusability/reflection/c3_getter_map_performance/GeradorMapaPerformance.java)

For add performance to code we may use strategies how reusability of code and share between instances.

In this test the code run up to 4x more fast in relation to code of example [1.1.Basic map getters](#1.1.basic_map_getters)

## 2.Annotations
