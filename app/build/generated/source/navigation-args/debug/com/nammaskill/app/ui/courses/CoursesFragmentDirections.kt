package com.nammaskill.app.ui.courses

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammaskill.app.R

public class CoursesFragmentDirections private constructor() {
  public companion object {
    public fun actionCoursesToDetail(): NavDirections =
        ActionOnlyNavDirections(R.id.action_courses_to_detail)

    public fun actionCoursesToApply(): NavDirections =
        ActionOnlyNavDirections(R.id.action_courses_to_apply)

    public fun actionCoursesToAddCourse(): NavDirections =
        ActionOnlyNavDirections(R.id.action_courses_to_addCourse)
  }
}
