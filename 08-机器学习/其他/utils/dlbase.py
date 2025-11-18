# utils/dlbase.py
import torch
from torch.utils import data
import matplotlib.pyplot as plt

def set_figsize(figsize=(3.5, 2.5)):
    """设置图像大小"""
    plt.rcParams['figure.figsize'] = figsize

def synthetic_data(w, b, num_examples):  
    """生成y=Xw+b+噪声"""
    X = torch.normal(0, 1, (num_examples, len(w)))
    y = torch.matmul(X, w) + b
    y += torch.normal(0, 0.01, y.shape)
    return X, y.reshape((-1, 1))

def scatter(features, labels, feature_index=1, s=1):
    """
    绘制特征与标签的散点图
    features: Tensor, 特征数据
    labels: Tensor, 标签数据
    feature_index: int, 选择第几列特征
    s: 点的大小
    """
    set_figsize()
    plt.scatter(features[:, feature_index].detach().numpy(),
                labels.detach().numpy(), s)
    plt.xlabel(f"Feature {feature_index}")
    plt.ylabel("Label")
    plt.show()

def linreg(X, w, b):  #@save
    """线性回归模型"""
    return torch.matmul(X, w) + b

def squared_loss(y_hat, y):  #@save
    """均方损失"""
    return (y_hat - y.reshape(y_hat.shape)) ** 2 / 2

def sgd(params, lr, batch_size):  #@save
    """小批量随机梯度下降"""
    with torch.no_grad():
        for param in params:
            param -= lr * param.grad / batch_size
            param.grad.zero_()

def load_array(data_arrays, batch_size, is_train=True):  #@save
    """构造一个PyTorch数据迭代器"""
    dataset = data.TensorDataset(*data_arrays)
    return data.DataLoader(dataset, batch_size, shuffle=is_train)

batch_size = 10
data_iter = load_array((features, labels), batch_size)         