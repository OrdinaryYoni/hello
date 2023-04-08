from abc import ABCMeta
from abc import abstractmethod

class AbstractDuck(metaclass=ABCMeta):
    @abstractmethod
    def Quack(self):
        pass
