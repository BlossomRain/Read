import os
from PIL import Image

# 设置最大边长
MAX_SIZE = 600

# 支持的图片后缀
SUPPORTED_EXTENSIONS = ('.jpg', '.jpeg', '.png', '.bmp', '.gif', '.webp')

def resize_image(path):
    try:
        with Image.open(path) as img:
            original_size = img.size
            # 获取宽和高
            w, h = original_size
            # 判断是否需要缩放
            if max(w, h) <= MAX_SIZE:
                return  # 不需要处理

            # 计算缩放比例
            scale = MAX_SIZE / max(w, h)
            new_size = (int(w * scale), int(h * scale))

            # 缩放并替换原图
            img = img.resize(new_size, Image.LANCZOS)
            img.save(path)
            print(f"Resized: {path} from {original_size} to {new_size}")
    except Exception as e:
        print(f"Failed to process {path}: {e}")

def process_directory(root_dir):
    for dirpath, _, filenames in os.walk(root_dir):
        for filename in filenames:
            if filename.lower().endswith(SUPPORTED_EXTENSIONS):
                full_path = os.path.join(dirpath, filename)
                resize_image(full_path)

if __name__ == "__main__":
    current_dir = os.getcwd()
    process_directory(current_dir)
