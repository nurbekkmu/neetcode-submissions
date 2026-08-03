import math

class AreaCalc:
    # TODO: Implement calculate method
    def calculate(self, length: float, width: float = None) -> float:
        if width == None:
            return round((math.pi * length * length), 2)
        return round((length * width), 2)    

    

    
# Don't modify the following code
calc = AreaCalc()
print(calc.calculate(5))    
print(calc.calculate(4, 6))
