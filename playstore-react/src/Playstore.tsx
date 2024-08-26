import React from "react";
import { Search, HelpCircle } from "lucide-react";

interface TopApp {
  name: string;
  description: string;
  rating: number;
}

const GooglePlayStore: React.FC = () => {
  const topApps: TopApp[] = [
    { name: "TikTok", description: "Xem và sửa video", rating: 3.8 },
    { name: "Shopee", description: "Mua sắm", rating: 4.0 },
    { name: "Zalo", description: "Liên lạc", rating: 4.0 },
    { name: "Messenger", description: "Liên lạc", rating: 3.3 },
  ];

  return (
    <div className="font-sans">
      {/* Header */}
      <header className="flex items-center justify-between p-4 bg-white">
        <div className="flex items-center space-x-2">
          <img
            src="https://placehold.co/32"
            alt="Google Play logo"
            className="w-8 h-8"
          />
          <h1 className="text-xl font-semibold">Google Play</h1>
        </div>
        <div className="flex items-center space-x-4">
          <Search className="w-6 h-6 text-gray-600" />
          <HelpCircle className="w-6 h-6 text-gray-600" />
          <div className="w-8 h-8 bg-purple-600 rounded-full flex items-center justify-center text-white">
            C
          </div>
        </div>
      </header>

      {/* Navigation */}
      <nav className="flex space-x-4 p-4 bg-white border-b">
        <button className="text-green-600 font-medium">Trò chơi</button>
        <button className="text-green-600 font-medium">Ứng dụng</button>
        <button className="text-gray-600">Phim</button>
        <button className="text-gray-600">Sách</button>
        <button className="text-gray-600">Trẻ em</button>
      </nav>

      {/* Device types */}
      <div className="flex space-x-4 p-4 bg-gray-100">
        <button className="bg-white px-3 py-1 rounded-full text-sm">
          Điện thoại
        </button>
        <button className="text-sm text-gray-600">Máy tính bảng</button>
        <button className="text-sm text-gray-600">Ti vi</button>
        <button className="text-sm text-gray-600">Chromebook</button>
        <button className="text-sm text-gray-600">Đồng hồ</button>
        <button className="text-sm text-gray-600">Xe ô tô</button>
      </div>

      {/* Featured App */}
      <div className="bg-black text-white p-6 flex items-center justify-between">
        <div>
          <p className="text-sm mb-2">Kết thúc sau 6 ngày nữa</p>
          <h2 className="text-2xl font-bold mb-2">
            Supernova X: Vòng 3 đang diễn ra
          </h2>
          <div className="flex items-center space-x-2">
            <img
              src="https://placehold.co/24"
              alt="StarMaker logo"
              className="w-6 h-6 rounded"
            />
            <span className="text-sm">StarMaker: hát ứng dụng karaoke</span>
          </div>
        </div>
        <img
          src="https://placehold.co/200"
          alt="Supernova X promo"
          className="w-40 h-40 object-cover"
        />
      </div>

      {/* Top Apps */}
      <div className="p-4">
        <h3 className="text-lg font-semibold mb-4">Bảng xếp hạng hàng đầu</h3>
        <div className="grid grid-cols-4 gap-4">
          {topApps.map((app, index) => (
            <div key={index} className="flex items-center space-x-3">
              <span className="text-lg font-semibold">{index + 1}</span>
              <img
                src={`https://placehold.co/48`}
                alt={`${app.name} logo`}
                className="w-12 h-12 rounded-xl"
              />
              <div>
                <p className="font-medium">{app.name}</p>
                <p className="text-sm text-gray-600">{app.description}</p>
                <div className="flex items-center">
                  <span className="text-sm">{app.rating}</span>
                  <span className="text-yellow-500 ml-1">★</span>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default GooglePlayStore;
