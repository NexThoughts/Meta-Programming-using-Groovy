class BootStrap {

    def init = { servletContext ->
        Integer.metaClass.getDaysFromNow = { ->
            Calendar today = Calendar.instance
            today.add(Calendar.DAY_OF_MONTH, delegate)
            today.time
        }
    }
    def destroy = {
    }
}
