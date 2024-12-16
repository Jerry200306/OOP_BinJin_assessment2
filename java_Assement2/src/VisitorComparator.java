// 文件路径: src/VisitorComparator.java
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 使用Visitor的两个实例变量进行比较，例如姓名和年龄
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        } else {
            return Integer.compare(v1.getAge(), v2.getAge());
        }
    }
}