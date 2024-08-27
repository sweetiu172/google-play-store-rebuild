import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Google Play Store Clone',
      theme: ThemeData(
        primarySwatch: Colors.green,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: PlayStoreHomePage(),
    );
  }
}

class PlayStoreHomePage extends StatelessWidget {
  final List<Map<String, dynamic>> topApps = [
    {'name': 'TikTok', 'description': 'Xem và sửa video', 'rating': 3.8},
    {'name': 'Shopee', 'description': 'Mua sắm', 'rating': 4.0},
    {'name': 'Zalo', 'description': 'Liên lạc', 'rating': 4.0},
    {'name': 'Messenger', 'description': 'Liên lạc', 'rating': 3.3},
  ];

  PlayStoreHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      key: const Key('home'),
      home: SafeArea(
        child: Column(
          children: [
            _buildHeader(),
            _buildNavigation(),
            _buildDeviceTypes(),
            _buildFeaturedApp(),
            _buildTopApps(),
          ],
        ),
      ),
    );
  }

  Widget _buildHeader() {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Row(
            children: [
              Image.network('https://placehold.co/32.png',
                  width: 32, height: 32),
              const SizedBox(width: 8),
              const Text('Google Play',
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.w600)),
            ],
          ),
          Row(
            children: [
              Icon(Icons.search, size: 24, color: Colors.grey[600]),
              const SizedBox(width: 16),
              Icon(Icons.help_outline, size: 24, color: Colors.grey[600]),
              const SizedBox(width: 16),
              CircleAvatar(
                backgroundColor: Colors.purple[600],
                child: const Text('C', style: TextStyle(color: Colors.white)),
              ),
            ],
          ),
        ],
      ),
    );
  }

  Widget _buildNavigation() {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: 16),
      decoration: BoxDecoration(
        border: Border(bottom: BorderSide(color: Colors.grey[300]!)),
      ),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: [
          Text('Trò chơi',
              style: TextStyle(
                  color: Colors.green[600], fontWeight: FontWeight.w500)),
          Text('Ứng dụng',
              style: TextStyle(
                  color: Colors.green[600], fontWeight: FontWeight.w500)),
          Text('Phim', style: TextStyle(color: Colors.grey[600])),
          Text('Sách', style: TextStyle(color: Colors.grey[600])),
          Text('Trẻ em', style: TextStyle(color: Colors.grey[600])),
        ],
      ),
    );
  }

  Widget _buildDeviceTypes() {
    return Container(
      padding: const EdgeInsets.symmetric(vertical: 16),
      color: Colors.grey[100],
      child: SingleChildScrollView(
        scrollDirection: Axis.horizontal,
        child: Row(
          children: [
            const SizedBox(width: 16),
            ElevatedButton(
              onPressed: () {},
              style: ElevatedButton.styleFrom(
                shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20)),
              ),
              child: const Text('Điện thoại'),
            ),
            const SizedBox(width: 8),
            _buildDeviceButton('Máy tính bảng'),
            _buildDeviceButton('Ti vi'),
            _buildDeviceButton('Chromebook'),
            _buildDeviceButton('Đồng hồ'),
            _buildDeviceButton('Xe ô tô'),
            const SizedBox(width: 16),
          ],
        ),
      ),
    );
  }

  Widget _buildDeviceButton(String text) {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 4),
      child: TextButton(
        onPressed: () {},
        child:
            Text(text, style: TextStyle(color: Colors.grey[600], fontSize: 14)),
      ),
    );
  }

  Widget _buildFeaturedApp() {
    return Container(
      padding: const EdgeInsets.all(24),
      color: Colors.black,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const Text('Kết thúc sau 6 ngày nữa',
                    style: TextStyle(color: Colors.white, fontSize: 12)),
                const SizedBox(height: 8),
                const Text(
                  'Supernova X: Vòng 3 đang diễn ra',
                  style: TextStyle(
                      color: Colors.white,
                      fontSize: 24,
                      fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 8),
                Row(
                  children: [
                    Image.network('https://placehold.co/24.png',
                        width: 24, height: 24),
                    const SizedBox(width: 8),
                    const Text('StarMaker: hát ứng dụng karaoke',
                        style: TextStyle(color: Colors.white, fontSize: 12)),
                  ],
                ),
              ],
            ),
          ),
          Image.network('https://placehold.co/200.png',
              width: 150, height: 150),
        ],
      ),
    );
  }

  Widget _buildTopApps() {
    return Expanded(
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const Text('Bảng xếp hạng hàng đầu',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.w600)),
            const SizedBox(height: 16),
            Expanded(
              child: GridView.builder(
                gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 2,
                  childAspectRatio: 3,
                  crossAxisSpacing: 16,
                  mainAxisSpacing: 16,
                ),
                itemCount: topApps.length,
                itemBuilder: (context, index) {
                  final app = topApps[index];
                  return Row(
                    children: [
                      Text('${index + 1}',
                          style: const TextStyle(
                              fontSize: 18, fontWeight: FontWeight.w600)),
                      const SizedBox(width: 12),
                      Image.network('https://placehold.co/48.png',
                          width: 48, height: 48),
                      const SizedBox(width: 12),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Text(app['name'],
                                style: const TextStyle(
                                    fontWeight: FontWeight.w500)),
                            Text(app['description'],
                                style: TextStyle(
                                    fontSize: 12, color: Colors.grey[600])),
                            Row(
                              children: [
                                Text(app['rating'].toString(),
                                    style: const TextStyle(fontSize: 12)),
                                Icon(Icons.star,
                                    size: 12, color: Colors.yellow[700]),
                              ],
                            ),
                          ],
                        ),
                      ),
                    ],
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
