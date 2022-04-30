<template>
	<view>
		<u-navbar :is-back="false" title="首页" :background="background"></u-navbar>
		<u-swiper :list="lunbolist"></u-swiper>

		<u-grid :col="2">
			<u-grid-item>
				<image src="../../static/icons/hospital.png" class="img-80" ></image>
				<view class="grid-text" style="font-size: 35upx;">医院介绍</view>
			</u-grid-item>
			<u-grid-item @tap="toYuyue()">
				<image src="../../static/icons/doctor.png" class="img-80"></image>
				<view class="grid-text" style="font-size: 35upx;">预约挂号</view>
			</u-grid-item>
			<u-grid-item >
				<image  src="../../static/icons/daozhen.png" class="img-80"></image>
				<view class="grid-text" style="font-size: 35upx;">自助导诊</view>
			</u-grid-item>
			<u-grid-item>
				<image src="../../static/icons/history.png" class="img-80"></image>
				<view class="grid-text" style="font-size: 35upx;">门诊记录</view>
			</u-grid-item>
		</u-grid>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				background: {
					backgroundColor: '#eeeeee',

				},
				lunbolist: [
					'../../static/imgs/lunbotu1.png',
					'../../static/imgs/lunbotu2.png',
					'../../static/imgs/lunbotu3.png',
				],
			}
		},
		onLoad() {
			
		},
		methods: {
		toYuyue(){
			uni.navigateTo({
				url:"../yuyuegua/yuyuegua"
			})
		}
		}
	}
</script>
<style scoped lang="scss">
	.grid-text {
		font-size: 28rpx;
		margin-top: 4rpx;
		color: $u-type-info;
	}
</style>
