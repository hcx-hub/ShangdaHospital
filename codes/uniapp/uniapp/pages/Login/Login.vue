<template>
	<view class="login" style="margin-top: 100upx;">
		<view class="top_item">
			<text style="color: #000000;font-size: 22px;font-weight: bold;">欢迎使用，商大医院！</text>
		</view>
		<view class="input-item" style="margin-top: 80rpx;">
			<view class="title-content">
				<!-- <text class="title">账号</text> -->
				<image src="../../static/icons/user.png" style="width: 60upx;height: 60upx;"></image>
			</view>
			<input class="input" placeholder="用户名" style="margin-left: 40rpx;" />
		</view>
		<view class="input-item">
			<view class="title-content">
				<!-- <text class="title">密码</text> -->
				<image src="../../static/icons/password.png" style="width: 60upx;height: 60upx;"></image>
			</view>
			<input class="input" placeholder="请输入密码" style="margin-left: 40rpx;" />

		</view>
		<view class="button" @tap="login">登录</view>

		<view class="" style="margin-top: 30upx;">
			<text style="color: #808080;font-size: 30upx;margin-left: 200upx; " @tap="">注册</text>
			<text style="color: #808080;font-size: 30upx;margin-left: 200upx; " @tap="">忘记密码</text>

		</view>
		<u-form :model="form" >
				<u-form-item label="姓名"><u-input v-model="form.username" /></u-form-item>
				<u-form-item label="简介"><u-input v-model="form.password" /></u-form-item>
				
				
			</u-form>




	</view>


</template>

<script>
	import request from "@/utils/request";
	export default {
		data() {
			return {
				form: {},
			}
		},
		methods: {
			login() {
				request.post("/patient/login", this.form).then(res => {
					console.log(res)
					
					if (res.code === '0') {
						console.log('000')
						sessionStorage.setItem("user", JSON.stringify(res.data)) //缓存用户信息，注意session的key是user
						//登录成功后进行页面跳转
						uni.switchTab({
							url:'../index/index'
						})
						console.log('111')
					} else {
						
					}

				})
			}
		}
	}
</script>

<style>
	.top_item {
		display: flex;
		margin-top: 40rpx;
		margin-left: 32rpx;
		margin-right: 32rpx;
		justify-content: space-between;
	}

	.input-item {
		display: flex;
		margin-left: 32rpx;
		margin-right: 32rpx;
		height: 50px;
		align-items: center;
		border-bottom: 1px solid #efeff4;
		margin-bottom: 20rpx;

		.title-content {
			display: flex;
			justify-content: flex-start;
			align-items: center;

			.title {
				font-size: 18px;
			}
		}

		.input {
			flex: 1;
		}
	}

	.button {
		height: 50px;
		line-height: 50px;
		margin-top: 60rpx;
		margin-left: 32rpx;
		margin-right: 32rpx;
		border-radius: 50rpx;
		font-size: 20px;
		background-color: #008AFE;
		color: #FFFFFF;
		text-align: center;
	}
</style>
