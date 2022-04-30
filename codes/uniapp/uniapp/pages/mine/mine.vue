<template>
	<view>
		<u-navbar :is-back="false" title="我" :background="background"></u-navbar>
		<view style="display: flex;margin: 30upx 25upx;">
			<view style="flex-direction: row; ">
				<u-image width="180upx" height="180rpx" shape="circle" style="margin-left: 20upx;" :src="imgsrc" />
			</view>
			<view style="margin: 20upx 40upx;">
				<view style="font-size:40upx;color: #333333;">
					李四
				</view>
				<view style="margin-top: 50upx;font-size: 30upx;color: #999999;">
					用户名:
				</view>
			</view>

		</view>
		<u-cell-group style="margin-top:50upx;">
			<u-cell-item icon="setting-fill" title="修改名称"></u-cell-item>
			<u-cell-item icon="lock-fill" title="修改密码"></u-cell-item>
		</u-cell-group>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				background: {
					backgroundColor: '#eeeeee',

				},
				imgsrc: ''
			}
		},
		
		methods: {
			load() {
				//获取用户名、头像等信息
				//如果判断为男生则img设为男生的头像
				if (true) {
					this.imgsrc = '../../static/icons/man.png'
				} else {
					this.imgsrc = '../../static/icons/female.png'
				}

			}
		}
	}
</script>

<style scoped lang="scss">
	// .wrap {
	// 	padding: 24rpx;
	// }

	// .u-row {
	// 	margin: 40rpx 0;
	// }

	// .demo-layout {
	// 	height: 80rpx;
	// 	border-radius: 8rpx;
	// }

	// .bg-purple {
	// 	background: #d3dce6;
	// }

	// .bg-purple-light {
	// 	background: #e5e9f2;
	// }

	// .bg-purple-dark {
	// 	background: #99a9bf;
	// }
</style>
