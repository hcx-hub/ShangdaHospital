<template>
	<view class="login" style="margin-top: 100upx;">
		<view class="top_item">
			<text style="color: #000000;font-size: 22px;font-weight: bold;">欢迎使用，商大医院！</text>
		</view>
		<u-form :model="form" style="margin-top: 80upx;width: 700upx;">
			<u-form-item label="" style="margin-left: 40upx;">
				<image src="../../static/icons/user.png" style="width: 60upx;height: 60upx;"></image>
				<u-input v-model="form.username" style="margin-left: 40upx;" />
			</u-form-item>
			<u-form-item label="" style="margin-left: 40upx;">
				<image src="../../static/icons/password.png" style="width: 60upx;height: 60upx;"></image>
				<u-input v-model="form.password" style="margin-left: 40upx;" />
			</u-form-item>


		</u-form>
		<u-button @click="submit" type="primary" class="button" @tap="login">登录</u-button>


		<view class="" style="margin-top: 30upx;">
			<text style="color: #808080;font-size: 30upx;margin-left: 200upx; " @tap="">注册</text>
			<text style="color: #808080;font-size: 30upx;margin-left: 200upx; " @tap="">忘记密码</text>

		</view>
		<u-toast ref="uToast" />

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
						sessionStorage.setItem("user", JSON.stringify(res.data)) //缓存用户信息，注意session的key是user
						//登录成功后进行页面跳转
						// this.successToast(res.msg)
						uni.switchTab({
							url: '../index/index'
						})

					} else {//登录失败
						this.failToast(res.msg)
						this.form.password=''//清空密码栏
						console.log(res.msg)
					}

				})
			},
			failToast(msg) {
				this.$refs.uToast.show({
					title: msg,
					type: 'error',
					// url: '../index/index',
					position: 'bottom',
				})
			},
			// successToast(msg) {
			// 	this.$refs.uToast.show({
			// 		title: msg,
			// 		type: 'success',
			// 		url: '../index/index',
			// 		position: 'bottom',
			// 		isTab:true
			// 	})
			// },
		},

	}
</script>

<style>
	.top_item {
		display: flex;
		margin-top: 40upx;
		margin-left: 32upx;
		margin-right: 32upx;
		justify-content: space-between;
	}

	.input-item {
		display: flex;
		margin-left: 32upx;
		margin-right: 32upx;
		height: 50px;
		align-items: center;
		border-bottom: 1px solid #efeff4;
		margin-bottom: 20upx;

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
		margin-top: 60upx;
		margin-left: 32upx;
		margin-right: 32upx;
		border-radius: 50upx;
		font-size: 20px;
		background-color: #008AFE;
		color: #FFFFFF;
		text-align: center;
	}
</style>
