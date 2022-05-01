<template>
	<view>
		<button type="default" @click="clk">sss</button>
	</view>
</template>

<script>
	import request from "@/utils/request";
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			clk(){
				var user={
					'username':'admin',
					'password':'123'
				}
				request.post("doctor/login",user).then(res=>{
				        console.log(res)
				       
				      })
			
			}
		}
	}
</script>

<style>

</style>
