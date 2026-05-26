package com.example.university_management.common;

import lombok.*;
import org.springframework.data.domain.Page;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> {
    private List<T> content;          // Danh sách dữ liệu (VD: List sinh viên)
    private int pageNumber;            // Trang hiện tại
    private int pageSize;              // Số lượng phần tử trên 1 trang
    private long totalElements;        // Tổng số bản ghi trong DB
    private int totalPages;            // Tổng số trang chia được
    private boolean isLast;            // Có phải trang cuối cùng không

    // Hàm tiện ích để convert nhanh từ Page của Spring sang PageResponse của mình
    public static <T> PageResponse<T> of(Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isLast(page.isLast())
                .build();
    }
}
