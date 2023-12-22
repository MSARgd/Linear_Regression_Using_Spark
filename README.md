# Linear Regression using Apache Spark

Linear Regression using Apache Spark

## Getting Started

### Prerequisites

- Apache Spark installed and configured on your system.
- Java 8 or later installed.

### Installation

1. Clone this repository:

    ```bash
    git clone https://github.com/MSARgd/Linear_Regression_Using_Spark.git
    ```

2. Set up Apache Spark in your project and configure the necessary dependencies in your build tool (e.g., Maven, SBT).

   For Maven, add the following dependencies:

    ```xml
    <dependencies>
        <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-core_2.12</artifactId>
            <version>3.2.0</version>
        </dependency>

        <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-sql_2.12</artifactId>
            <version>3.2.0</version>
        </dependency>

        <dependency>
            <groupId>org.apache.spark</groupId>
            <artifactId>spark-mllib_2.12</artifactId>
            <version>3.2.0</version>
        </dependency>
    </dependencies>
    ```

