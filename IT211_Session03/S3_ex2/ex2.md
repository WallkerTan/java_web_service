1: 
Thành phần trong http REQUEST
    method
        post: dùng dể gửi dữ liệu mới
    URL
        /api/sanpham
            endpoint để tạo sản phẩm mới
    HEADERS
        content-type: aplication/json
            cho service biết dữu liệu trong body gửi dưới dạng json
        Athorization: Bearer abc123
            cung cấp token để cung cấp quyền truy cập
        Content-leng: 48
            cho server biết đọ dài dữ liệu trong body(48 byte)
    BODY
        dữ liệu sản phẩm....

2: 
Thành phần trong http RESPONSE
    STATUS-LINE: HTTP/1.1 CREATED
        báo hiệu yêu cầu thành công , dữ liêu đã được tạo
    HEADERS
        DATE
            thời điểm server phản hồi
        CONTENT-TYPE
            kiểu trả về JSON
        LOCATION: /api/sanpham/101
            đường đẫn đến dữ liệu mới được thêm vào
    BODY
        dữ liệu mới được thêm vào

3:
Mã trạng thái:
    201 Created thuộc nhóm 2xx (Success). 
Ý nghĩa: 
    yêu cầu đã được xử lý thành công và một tài nguyên mới đã được tạo.

4:
Trường hợp 
    GET /api/sanpham/999 nhưng sản phẩm không tồn tại
Server 
    sẽ trả về 404 Not Found.
Ý nghĩa 
    tài nguyên được yêu cầu không tồn tại trên server.

5:
server 
    gặp lỗi xử lý không xác định
Mã trạng thái thường dùng 
    500 Internal Server Error (thuộc nhóm 5xx – Server Error).
Ý nghĩa 
    server gặp lỗi không mong đợi khi xử lý request, không thể hoàn thành yêu cầu.