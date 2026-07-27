# Thunder Sword — Mod Minecraft 1.20.1 (Forge)

Mod thêm **Kiếm Sấm Sét**: mạnh hơn kiếm kim cương, mỗi lần đánh trúng có
25% tỉ lệ gọi sét đánh thẳng vào mục tiêu.

## Tính năng
- Sát thương cơ bản cao hơn kiếm kim cương (+1 damage, độ bền ~2031 lần dùng).
- 25% tỉ lệ triệu hồi sét khi đánh trúng địch (`ThunderSwordItem#hurtEnemy`).
- Công thức chế tạo: **Đinh Ba (Trident) + Kim Cương + Gậy** xếp theo hàng dọc.
- Xuất hiện trong tab Creative "Combat".
- Có tên tiếng Việt: "Kiếm Sấm Sét" (dùng `vi_vn.json`).

## Cách build (cần máy có Internet, JDK 17)
1. Cài Java Development Kit 17 (bắt buộc cho Forge 1.20.1).
2. Mở terminal tại thư mục gốc của project này (chứa file `build.gradle`).
3. Chạy lệnh sau để build file mod:
   - Windows: `gradlew.bat build`
   - macOS/Linux: `./gradlew build`
4. Lần build đầu sẽ tự tải Forge MDK + các dependency (cần mạng, mất vài phút).
5. File `.jar` kết quả nằm trong `build/libs/thundersword-1.0.0.jar`.
6. Copy file `.jar` đó vào thư mục `mods` của Minecraft (đã cài Forge 1.20.1 - 47.2.0).

> Lưu ý: project này thiếu file `gradlew` / `gradlew.bat` (Gradle wrapper binary)
> vì không có mạng khi tạo mod. Cách nhanh nhất để bổ sung:
> - Cài Gradle 8.x trên máy, sau đó chạy `gradle wrapper --gradle-version 8.1.1`
>   ngay trong thư mục project — lệnh này sẽ tự sinh `gradlew`, `gradlew.bat`
>   và thư mục `gradle/wrapper/`.
> - Hoặc mở project bằng IntelliJ IDEA / Eclipse có cài **Minecraft Forge
>   Plugin**, IDE sẽ tự tạo wrapper khi import project Gradle.

## Cách build bằng GitHub Actions (không cần cài gì trên máy)
Project đã có sẵn file `.github/workflows/build.yml` tự động build ra `.jar`
trên server của GitHub, bạn chỉ cần trình duyệt:

1. Tạo tài khoản GitHub (nếu chưa có) tại github.com.
2. Tạo repository mới (New repository), đặt tên tuỳ ý, ví dụ `thundersword`.
   Không cần tick "Add README" (repo trống là được).
3. Upload toàn bộ nội dung thư mục `thundersword` (sau khi giải nén zip) lên
   repo đó — cách dễ nhất: vào trang repo trên GitHub, bấm "Add file" >
   "Upload files", kéo thả toàn bộ file/folder vào, rồi bấm "Commit changes".
   (Nếu quen dùng Git dòng lệnh thì `git add . && git commit -m "init" && git push` cũng được.)
4. Vào tab **Actions** ở đầu trang repo. GitHub sẽ tự chạy workflow
   "Build Thunder Sword mod" ngay sau khi bạn push code (mất khoảng 3-6 phút).
5. Khi thấy dấu tích xanh (hoàn tất), bấm vào lần chạy đó, kéo xuống mục
   **Artifacts**, tải file `thundersword-jar.zip` về — bên trong là file
   `.jar` bạn cần.
6. Copy file `.jar` vào thư mục `mods` của Minecraft (đã cài Forge 1.20.1 - 47.2.0).

> Nếu build lỗi, vào tab Actions > chọn lần chạy bị lỗi > xem log đỏ, gửi
> đoạn lỗi đó cho mình để mình sửa code giúp bạn.

## Cách chỉnh sửa
- `ThunderSwordItem.java`: đổi tỉ lệ sét (`STRIKE_CHANCE`), thêm hiệu ứng khác.
- `ThunderTier.java`: chỉnh độ bền, sát thương, tốc độ khai thác.
- `ModItems.java`: đổi damage/attack speed khi khởi tạo item.
- `thunder_sword.json` (recipes): đổi nguyên liệu chế tạo.
- `thunder_sword.png` (textures/item): texture 16x16 hiện tại chỉ là placeholder
  đơn giản — bạn nên thay bằng texture đẹp hơn (dùng Blockbench hoặc vẽ tay).

## Cấu trúc thư mục
```
thundersword/
├── build.gradle
├── settings.gradle
├── gradle.properties
└── src/main/
    ├── java/com/example/thundersword/
    │   ├── ThunderSwordMod.java       (class chính)
    │   └── item/
    │       ├── ModItems.java         (đăng ký item)
    │       ├── ThunderSwordItem.java (logic đánh + gọi sét)
    │       └── ThunderTier.java      (thông số vật liệu)
    └── resources/
        ├── META-INF/mods.toml
        ├── pack.mcmeta
        ├── assets/thundersword/
        │   ├── lang/{en_us,vi_vn}.json
        │   ├── models/item/thunder_sword.json
        │   └── textures/item/thunder_sword.png
        └── data/thundersword/recipes/thunder_sword.json
```
