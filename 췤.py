import struct
struct_fmt = '=16s2fi'  # char[16],float[2], int
city_info = [
    # CITY,              Latitude,  Longitude,  Population
    ('서울'.encode(encoding='utf-8'), 37.566535, 126.97769, 9820000),
    ('뉴욕'.encode(encoding='utf-8'), 40.712784,-74.005941, 8400000),
    ('파리'.encode(encoding='utf-8'), 48.856614, 2.352222,  2210000),
    ('런던'.encode(encoding='utf-8'), 51.507351, -0.127758, 8300000)
    ]

with open('cities.dat','wb') as file:
    for city in city_info:
        file.write(struct.pack(struct_fmt, *city))
        
