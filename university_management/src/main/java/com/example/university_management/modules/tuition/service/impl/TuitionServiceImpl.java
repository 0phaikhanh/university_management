package com.example.university_management.modules.tuition.service.impl;

import com.example.university_management.exeption.NotFoundException;
import com.example.university_management.modules.tuition.dto.TuitionRequestDTO;
import com.example.university_management.modules.tuition.entity.Tuition;
import com.example.university_management.modules.tuition.repository.TuitionRepository;
import com.example.university_management.modules.tuition.service.TuitionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TuitionServiceImpl implements TuitionService {

    private final TuitionRepository tuitionRepository;

    public TuitionServiceImpl(TuitionRepository tuitionRepository) {
        this.tuitionRepository = tuitionRepository;
    }

    @Override
    public List<Tuition> getAllTuitions() {
        return tuitionRepository.findAll();
    }

    @Override
    public Tuition getTuitionById(Long id) {
        return tuitionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy thông tin học phí với ID: " + id));
    }

    @Override
    public Tuition createTuition(TuitionRequestDTO dto) {
        // Kiểm tra trùng UNIQUE (student_id, semester_id)
        tuitionRepository.findByStudentIdAndSemesterId(dto.getStudentId(), dto.getSemesterId())
                .ifPresent(t -> {
                    throw new RuntimeException("Học phí của sinh viên trong học kỳ này đã được khởi tạo!");
                });

        Tuition tuition = Tuition.builder()
                .studentId(dto.getStudentId())
                .semesterId(dto.getSemesterId())
                .totalFee(dto.getTotalFee())
                .discountAmount(dto.getDiscountAmount())
                .paidAmount(dto.getPaidAmount())
                .status(dto.getStatus())
                .build();

        return tuitionRepository.save(tuition);
    }

    @Override
    public Tuition updateTuition(Long id, TuitionRequestDTO dto) {
        Tuition existing = tuitionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy thông tin học phí để cập nhật!"));

        existing.setStudentId(dto.getStudentId());
        existing.setSemesterId(dto.getSemesterId());
        existing.setTotalFee(dto.getTotalFee());
        existing.setDiscountAmount(dto.getDiscountAmount());
        existing.setPaidAmount(dto.getPaidAmount());
        existing.setStatus(dto.getStatus());

        return tuitionRepository.save(existing);
    }

    @Override
    public void deleteTuition(Long id) {
        Tuition existing = tuitionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy thông tin học phí để xóa!"));
        tuitionRepository.delete(existing);
    }
}
