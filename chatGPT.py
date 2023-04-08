import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier

# 데이터 로드
data = pd.read_csv('data.csv')

# feature, target 데이터 분리
X = data.drop('target', axis=1)
y = data['target']

# 훈련 데이터와 테스트 데이터 분리
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2)

# 결정 트리 모델 학습
model = DecisionTreeClassifier()
model.fit(X_train, y_train)

# 모델 평가
accuracy = model.score(X_test, y_test)
print('Accuracy:', accuracy)
