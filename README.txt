# NThreads
Java code to create N threads and run them for T seconds. Intended to monitor CPU(s) utilization and scheduling.

cd  NComputeThreads
mvn compile package

Usage: java -jar target/NComputeThrgads*.jar <N> <T>
        N (+int) : number of threads to run.
        T (+int) : the runtime duration.

