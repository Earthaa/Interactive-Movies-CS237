# Interactive Movie
An interactive film, also known as an interactive movie or movie game, is a video game that presents its gameplay in a cinematic, scripted manner, often through the use of full-motion video of either animated or live-action footage. In modern times,[when?] the term also refers to games that have a larger emphasis on story/presentation than on gameplay.

# Introducction
This project is for UCI CS237 Middleware and Distributed System, which implements an interactive movie framework based on hadoop and hdfs. We use layered-cache to accelerate the the speed to handle movie clips.</br>
In some existing methods:</br>
WebHDFS/streamFile require that HDFS Clusters be exposed in public network and WebHDFS can't fast forward.</br>
HTTPFS Gateway can't fast forward too.</br>
This Project use web server as a gateway.HDFS Clusters don't need to be exposed in public network and it supports fast forward.</br>

# The default folder of Video
/video
# Usage 
1、Modify the ip address and port in com.constants.Constants.java into the namenode's IP and port.</br>
2、Modify the fpath parameter in http://localhost:8080/HDFSVideoDemo/stream?id=trailer in movie.html into the HDFS path of the video file you want to play.</br>
3、Deploy the web project in a web server and start it.</br>
4、Visit http://localhost:8080/HDFSVideoDemo/movie.html in a browser.</br>
</br>

# Notice 
1、This project use the new label <video> which now only supports Ogg,MPEG4(MP4),WebM.If you want more video types,try to use another web video player.As the same time,please use the browsers which supports HTML5.</br>
2、This poject supports videos' downloading.Just access the url in video label in browser.</br>
3、This project is a maven project.If you don't use maven,please download the required jars from http://pan.baidu.com/s/1gf33IpH and build the web project yourself.
</br>
# Demo
<img src="https://github.com/Earthaa/Interactive-Movies-CS237/blob/master/demo1.png"  alt="demo1" />
<img src="https://github.com/Earthaa/Interactive-Movies-CS237/blob/master/demo2.png"  alt="demo2" />


