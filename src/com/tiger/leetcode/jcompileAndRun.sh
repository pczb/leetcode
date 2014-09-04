path=~/Desktop/leetcode/out/production/leetcode/
ext=.java
package='com.tiger.leetcode.'
javac $1$ext -d $path 
cd $path 
java $package$1
