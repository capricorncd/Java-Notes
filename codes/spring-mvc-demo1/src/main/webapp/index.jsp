<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width"/>
		<title>Home</title>
	</head>
	<body>
		<div id="app">
			<h2>{{ data.title }}</h2>
			<div class="course-image" style="position:relative">
				<img :src="data.imgPath" style="width:200px;height:auto;"/>
				<ul style="position:absolute;left: 220px;top:0;">
					<li>学习人数：<em>{{data.learningNum}}</em></li>
					<li>课程时长：<em>{{data.duration}}</em> s</li>
					<li>课程难度：<em>{{data.level}}</em></li>
					<li>难度描述：<em>{{data.levelDesc}}</em></li>
					<li>课程介绍：<em>{{data.desc}}</em></li>
				</ul>
			</div>
			<h3 class="chapter-catalog">课程提纲</h3>
			<ol style="margin: 0;">
				<li v-for="(item, i) in data.chapterList" :key="i">
					<div class="outline-list">
						<h5 class="outline-name">{{item.title}}</h5>
						<p class="outline-descr">{{item.desc}}</p>
					</div>
				</li>
			</ol>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/vue"></script>
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
		<script>
			var vm = new Vue({
				el: '#app',
				created: function() {
					this.initData();
				},
				data: function() {
					return {
						data: {}
					}
				},
				methods: {
					initData: function() {
						axios.get('/courses/json/132')
						  .then(function (response) {
						    // handle success
						    console.log(response);
						    vm.data = response.data;
						  })
						  .catch(function (error) {
						    // handle error
						    console.log(error);
						  })
						  .finally(function () {
						    // always executed
						  });
					}
				}
			})
		</script>
	</body>
</html>
