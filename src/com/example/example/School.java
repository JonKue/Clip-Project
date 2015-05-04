package com.example.example;

public class School {

    //private variables
    final int _id;

    String _schoolName;
    String _degreeType;
    String _program;

    String _enrollment;
    String _dateStart;
    String _dateGrad;
    String _tuition;
    String _course;
    String _appDate;
    String _appStat;
    String _type; // Current/Future Education

    public School(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String get_schoolName() {
        return _schoolName;
    }

    public void set_schoolName(String _schoolName) {
        this._schoolName = _schoolName;
    }

    public String get_degreeType() {
        return _degreeType;
    }

    public void set_degreeType(String _degreeType) {
        this._degreeType = _degreeType;
    }

    public String get_program() {
        return _program;
    }

    public void set_program(String _program) {
        this._program = _program;
    }

    public String get_enrollment() {
        return _enrollment;
    }

    public void set_enrollment(String _enrollment) {
        this._enrollment = _enrollment;
    }

    public String get_dateStart() {
        return _dateStart;
    }

    public void set_dateStart(String _dateStart) {
        this._dateStart = _dateStart;
    }

    public String get_dateGrad() {
        return _dateGrad;
    }

    public void set_dateGrad(String _dateGrad) {
        this._dateGrad = _dateGrad;
    }

    public String get_tuition() {
        return _tuition;
    }

    public void set_tuition(String _tuition) {
        this._tuition = _tuition;
    }

    public String get_course() {
        return _course;
    }

    public void set_course(String _course) {
        this._course = _course;
    }

    public String get_appDate() {
        return _appDate;
    }

    public void set_appDate(String _appDate) {
        this._appDate = _appDate;
    }

    public String get_appStat() {
        return _appStat;
    }

    public void set_appStat(String _appStat) {
        this._appStat = _appStat;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String toString() {
        return this._schoolName;
    }
}