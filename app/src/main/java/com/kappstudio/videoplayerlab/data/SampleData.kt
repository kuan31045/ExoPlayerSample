package com.kappstudio.videoplayerlab.data

object SampleData {

    var myList: List<Product> = listOf(
        Product(
            id = "p1",
            name = "可愛狗狗",
            cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/dog.PNG?alt=media&token=5c46f1ad-79fa-4d50-8f5d-022feb48d624",
            desc = "\" 繼【魔戒】後全球再掀奇幻狂潮；凜冬將至、群雄爭霸，超強卡司與壯闊格局立下電視影集新標竿。 \" - 編輯推薦\n" +
                    "丹妮莉絲抵達臨冬城，瓊恩雪諾獲得一些大消息。",
            isSeries = true,
            videoList = listOf(
                VideoItem(
                    id = "v1",
                    productId = "p1",
                    title = "E1 可愛狗狗",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/dog.PNG?alt=media&token=5c46f1ad-79fa-4d50-8f5d-022feb48d624",
                    video = "https://storage.googleapis.com/exoplayer-test-media-1/mp4/android-screens-10s.mp4",
                    desc = "丹妮莉絲抵達臨冬城，瓊恩雪諾獲得一些大消息。"
                ),
                VideoItem(
                    id = "v2",
                    productId = "p1",
                    title = "E2 可愛狗狗",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/dog.PNG?alt=media&token=5c46f1ad-79fa-4d50-8f5d-022feb48d624",
                    video = "https://storage.googleapis.com/exoplayer-test-media-1/mp4/android-screens-25s.mp4",
                    desc = "詹姆在心存懷疑的聽眾面前，為自己的情況辯解。"
                ),
                VideoItem(
                    id = "v3",
                    productId = "p1",
                    title = "E3 可愛狗狗",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/dog.PNG?alt=media&token=5c46f1ad-79fa-4d50-8f5d-022feb48d624",
                    video = "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segment/video-avc-baseline-480.mp4",
                    desc = "艾莉亞想證明自己身為戰士的價值。"
                ),
                VideoItem(
                    id = "v4",
                    productId = "p1",
                    title = "E4 可愛狗狗",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/dog.PNG?alt=media&token=5c46f1ad-79fa-4d50-8f5d-022feb48d624",
                    video = "https://storage.googleapis.com/exoplayer-test-media-1/gen-3/screens/dash-vod-single-segment/video-137.mp4",
                    desc = "瓊恩和丹妮莉絲在付出慘痛代價贏得勝利後揮軍南下，此時提利昂尋求可以拯救無數生命的折衷辦法。"
                )
            )
        ),
        Product(
            id = "p2",
            name = "可愛貓貓",
            cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/cat.PNG?alt=media&token=871e0873-0fca-4f3d-b9b9-8f4916ca07b1",
            desc = "\" IMDb史上最高評價影集，勇奪金球最佳迷你影集兩項大獎。謊言的代價是什麼？寫實還原車諾比核災震撼神作。 \" - 編輯推薦\n" +
                    "1986年蘇聯一座核能電廠發生爆炸，廠內員工與消防隊員奮不顧身努力控制災情。",
            isSeries = true,
            videoList = listOf(
                VideoItem(
                    id = "v5",
                    productId = "p2",
                    title = "E1 可愛貓貓",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/cat.PNG?alt=media&token=871e0873-0fca-4f3d-b9b9-8f4916ca07b1",
                    video = "https://html5demos.com/assets/dizzy.mp4",
                    desc = "1986年蘇聯一座核能電廠發生爆炸，廠內員工與消防隊員奮不顧身努力控制災情。"
                ),
                VideoItem(
                    id = "v6",
                    productId = "p2",
                    title = "E2 可愛貓貓",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/cat.PNG?alt=media&token=871e0873-0fca-4f3d-b9b9-8f4916ca07b1",
                    video = "https://storage.googleapis.com/exoplayer-test-media-1/mp4/dizzy-with-tx3g.mp4",
                    desc = "車諾比核電廠爆炸後，數以百萬計的無辜生命陷入危險。核子物理學家烏拉娜庫米約克努力與勒加索夫聯繫，對他提出可能發生二次爆炸的警告，到時將危及整個歐亞大陸。"
                )
            )
        ),
        Product(
            id = "p3",
            name = "倒數一小時",
            cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/hour.PNG?alt=media&token=1501350a-5400-4627-b34f-4b9e6332f3a9",
            desc = "\" 導演刻意模糊夢境與現實的界線，讓這部高度原創又充滿想像力的電影每次看都會有新的發現。 \" - 編輯推薦\n" +
                    "偷技高超的神偷唐姆柯比（李奧納多狄卡皮歐飾），對客戶委託的偷竊行動無往不利，但是，其行蹤卻涉遍最驚險、最神秘的潛意識範圍，他的目標，是趁對象進入深沉的睡眠、心智遂呈現最脆弱狀態時，入侵其潛意識，將最不可告人的機密手到擒來。",
            isSeries = false,
            videoList = listOf(
                VideoItem(
                    id = "v7",
                    title="倒數一小時",
                    productId = "p3",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/hour.PNG?alt=media&token=1501350a-5400-4627-b34f-4b9e6332f3a9",
                    video = "https://storage.googleapis.com/exoplayer-test-media-1/mp4/frame-counter-one-hour.mp4",
                )
            )
        ),
        Product(
            id = "p4",
            name = "大兔子邦克",
            cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/bunny.PNG?alt=media&token=9d43f34d-96e2-4abf-a08e-17a21469134e",
            desc = "\" 有神快拜！昆丁導演轟動全球的黑色喜劇經典，暴力、碎嘴、時序重組樣樣來，創新敘事手法改寫電影規則。 \" - 編輯推薦\n" +
                    "鬼才編導昆丁塔倫提諾走紅全球的不敗神片！以大量對話佐以黑色幽默，甫推出即轟動影壇，贏得坎城金棕櫚大獎、奧斯卡最佳原著劇本，約翰屈伏塔、山繆傑克森、布魯斯威利、烏瑪舒曼共創無數經典橋段。一對殺人不眨眼但熱愛閒聊的殺手、冷酷的黑幫老大與他神祕性感的嬌妻、一個在名聲與金錢間掙扎的過氣拳擊手，以及一對搶匪情侶檔；這群人的離奇遭遇構成3段妙趣橫生、巧妙串連的荒謬故事...",
            isSeries = false,
            videoList = listOf(
                VideoItem(
                    id = "v8",
                    title="大兔子邦克",
                    productId = "p4",
                    cover = "https://firebasestorage.googleapis.com/v0/b/publisher-77e03.appspot.com/o/bunny.PNG?alt=media&token=9d43f34d-96e2-4abf-a08e-17a21469134e",
                    video = "https://storage.googleapis.com/downloads.webmproject.org/av1/exoplayer/bbb-av1-480p.mp4",
                )
            )
        )
    )

}


