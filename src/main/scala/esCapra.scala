rddCapra.count
rddCapra.collect
rddCapra.map(_.split(" ")).collect
rddCapra.flatMap(_.split(" ")).collect
rddCapra.flatMap(x => x.split(" ").map((_,1))).reduceByKey(_+_).collect
rddCapra.flatMap(x => x.split(" ").map(w =>(w.size,1))).reduceByKey(_+_).collect
rddCapra.flatMap(x => x.split(" ").map(w =>(w.substring(0,1), w.size))).reduceByKey((x, y) => (x + y) / 2).collect

rddCapra.zipWithIndex.flatMap{case (x, v) => x.split(" ").map((_, Set(v)))}.reduceByKey((x, y) => x ++ y).collect
