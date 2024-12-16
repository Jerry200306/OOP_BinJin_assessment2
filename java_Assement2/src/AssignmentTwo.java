// 文件路径: src/AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
        partSeven();
    }

    public static void partThree() {
        // 创建一个新的Ride对象
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));

        // 添加至少5个Visitor到队列
        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        // 从队列中移除一个Visitor
        ride.removeVisitorFromQueue(v3);

        // 打印队列中的所有Visitor
        ride.printQueue();
    }
    public static void partFourA() {
        // 创建一个新的Ride对象
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));

        // 添加至少5个Visitor到集合
        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // 检查一个Visitor是否在集合中
        System.out.println("Checking if a visitor is in the collection:");
        ride.checkVisitorFromHistory(v3);

        // 打印集合中的Visitor数量
        System.out.println("Number of visitors in the collection: " + ride.numberOfVisitors());

        // 打印所有Visitor
        ride.printRideHistory();
    }
    public static void partFourB() {
        // 创建一个新的Ride对象
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));

        // 添加至少5个Visitor到集合
        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // 打印集合中的所有Visitor
        System.out.println("Visitors before sorting:");
        ride.printRideHistory();

        // 对集合进行排序
        ride.sortHistory();

        // 再次打印集合中的所有Visitor以显示排序结果
        System.out.println("Visitors after sorting:");
        ride.printRideHistory();
    }
    public static void partFive() {
        // 创建一个新的Ride对象
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));
        ride.setMaxRider(3); // 设置每次运行可以乘坐的游客数量

        // 添加至少10个Visitor到队列
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor("Visitor" + i, 20 + i, "V" + i, "T" + i, "Level" + i);
            ride.addVisitorToQueue(visitor);
        }

        // 打印队列中的所有Visitor
        System.out.println("Visitors in the queue before running the ride:");
        ride.printQueue();

        // 运行一次周期
        ride.runOneCycle();

        // 打印队列中的所有Visitor
        System.out.println("Visitors in the queue after running the ride:");
        ride.printQueue();

        // 打印集合中的所有Visitor
        System.out.println("Visitors who have taken the ride:");
        ride.printRideHistory();
    }
    public static void partSix() {
        // 创建一个新的Ride对象
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));

        // 添加至少5个Visitor到LinkedList
        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 20, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 30, "V003", "T003", "Gold");
        Visitor v4 = new Visitor("David", 22, "V004", "T004", "Bronze");
        Visitor v5 = new Visitor("Eva", 28, "V005", "T005", "Gold");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // 导出Visitors到文件
        String filePath = "ride_history.txt";
        ride.exportRideHistory(filePath);
    }
    public static void partSeven() {
        // 创建一个新的Ride对象
        Ride ride = new Ride("Roller Coaster", 10, new Employee("John Doe", 30, "E123", "D123", "Rides"));

        // 导入之前创建的文件
        String filePath = "ride_history.txt";
        ride.importRideHistory(filePath);

        // 打印LinkedList中的Visitor数量以确认导入的正确性
        System.out.println("Number of visitors imported: " + ride.history.size());

        // 打印LinkedList中的所有Visitor以确认每个Visitor的详细信息已正确导入
        System.out.println("Visitors in the LinkedList:");
        ride.printRideHistory();
    }
}

